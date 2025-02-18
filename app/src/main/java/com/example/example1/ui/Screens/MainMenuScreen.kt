package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainMenuScreen(navHostController: NavHostController){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()


    ){
        Text("Main Menu")
        Button(
            onClick = {navHostController.navigate("Home_Screen") }

        ) {
            Text("Go to Home Screen")
        }
        Button(
            onClick = {navHostController.navigate("test_screen") }
        ) {
            Text("Go to Test Screen")
        }
    }
}