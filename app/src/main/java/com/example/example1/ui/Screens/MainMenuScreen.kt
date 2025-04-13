package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.example1.R

@Composable
fun MainMenuScreen(navHostController: NavHostController){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center



    ){
        Text("Main Menu",
            fontSize = 25.sp)
        Button(
            onClick = {navHostController.navigate("Home_Screen")
                 }

        ) {
            Text("Go to Home Screen",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary)
        }
        Button(
            onClick = {navHostController.navigate("test_screen") }
        ) {
            Text("Go to Test Screen",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary)
        }
        Button(
            onClick = {navHostController.navigate("StockApp") }

        ) {

            Text(text="Go to App Stock",
               fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary)
        }
        Button(
            onClick = {navHostController.navigate("components_screen") }

        ) {

            Text(text="Go to Components Screen",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary)
        }
       Button(
            onClick = {navHostController.navigate("LoginScreen")
            }

        ) {
            Text("Go to Login Screen",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary)
        }
       }
    }
