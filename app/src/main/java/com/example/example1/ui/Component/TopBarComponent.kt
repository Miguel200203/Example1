package com.rick.workclass.ejemplo.com.example.example1.ui.Component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(title:String, navController: NavController, location:String){
    TopAppBar(
        title = { Text(title, color = MaterialTheme.colorScheme.secondary)},
        actions = {
            if(location=="AccountsScreen"){
                IconButton(onClick = { navController.navigate("ManageAccountsScreen") }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add",
                        tint=MaterialTheme.colorScheme.secondary)
                }
            IconButton(onClick = { navController.navigate("FavoriteAccountsScreen") }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorites",
                        tint=MaterialTheme.colorScheme.secondary)
            }

        }
        }
    )

}