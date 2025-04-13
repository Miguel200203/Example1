package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.rick.workclass.ejemplo.com.example.example1.data.model.AccountEntity
import com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase.AppDataBase
import com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase.DatabaseProvider
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.FavoriteAccountCard
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun FavoriteAccountsScreen(navController: NavController) {
    val db: AppDataBase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.AccountDao()
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        accountsdb = withContext(Dispatchers.IO) {
            accountDao.getAll()
        }
    }

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.tertiary)) {
        TopBarComponent("Favorite Accounts", navController, "FavoriteAccountsScreen")
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState
        ) {
            items(accountsdb) { accountdb ->
                FavoriteAccountCard (
                    id = accountdb.id ?: 0,
                    name = accountdb.name ?: "",
                    username = accountdb.username ?: "",
                    password = accountdb.password ?: "",
                    imageURL = accountdb.imageURL ?: "",
                    description = accountdb.description ?: "",
                    onDeleteClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            try{
                                accountDao.delete(accountdb)
                                //update the consult so the deleted element can disappear from screen immediately
                                accountsdb = withContext(Dispatchers.IO){
                                    accountDao.getAll()
                                }
                                Log.d("debug-db", "Account deleted successfully")
                            } catch(exception: Exception) {
                                Log.d("debug-db", "ERROR: $exception")
                            }
                        }
                    }
                )
            }
        }
        TopBarComponent("FavoriteAccounts", navController, "favAcScreen")
    }
}
