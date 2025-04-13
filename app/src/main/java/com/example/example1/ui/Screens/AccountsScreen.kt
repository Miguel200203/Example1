package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rick.workclass.ejemplo.com.example.example1.data.ViewModel.AccountViewModel
import com.rick.workclass.ejemplo.com.example.example1.data.model.AccountModel
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.AccountCardComponent
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.TopBarComponent
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase.AppDataBase
import com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase.DatabaseProvider
import com.rick.workclass.ejemplo.com.example.example1.data.model.toAccountEntity
import com.rick.workclass.ejemplo.com.example.example1.ui.Component.AccountDetailCardComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(
    navController: NavHostController,
    viewModel: AccountViewModel = viewModel()

) {
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var accountDetail by remember { mutableStateOf<AccountModel?>(null) }
    val db: AppDataBase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.AccountDao()
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ){
        TopBarComponent(title = "Account Screen", navController, "AccountsScreen")
        //Launched effect is used to show animations and other things, in this case it will
        //be used to call the api and manage the interface updates.
        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if(response.isSuccessful){
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load accounts: ${response.code()}")
                }
            }
        }
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState
        ){
            items(accounts) { account ->
                AccountCardComponent(
                    account.id,
                    account.name,
                    account.username,
                    account.imageURL,


                        onButtonClick = {

                            viewModel.getAccount(account.id){ response ->
                                if(response.isSuccessful){
                                    accountDetail = response.body()
                                }
                            }
                            showBottomSheet = true

                        }
                    )

            }
        }
    }
    if(showBottomSheet){
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxHeight(),
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.background,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
        ) {
            AccountDetailCardComponent(
                accountDetail?.id ?: 0,
                accountDetail?.name ?: "",
                accountDetail?.username ?: "",
                accountDetail?.password ?: "",
                accountDetail?.imageURL ?: "",
                accountDetail?.description ?: "",
                onSaveClick = {

                    CoroutineScope(Dispatchers.IO).launch {
                        try{
                            accountDetail?.let {accountDao.insert(it.toAccountEntity())}
                            Log.d("debug-db", "Account inserted successfully")
                        } catch(exception: Exception) {
                            Log.d("debug-db", "ERROR: $exception")
                        }
                    }
                    showBottomSheet = false
                },
                navController
            )
        }
    }
}
