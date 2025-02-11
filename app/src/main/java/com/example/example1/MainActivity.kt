package com.example.example1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example1.ui.theme.Example1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Example1Theme {
                Column(){
                    Column(){
                        TextComposable("Miguel")
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Column(){
                        modifierExample2()
                    }
                }

            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name:String = "Empty"){
        Text("Welcome ")
        Text(name)
    }
    @Preview(showBackground = true)
    @Composable
    fun modifierExample1(){
        Column(
            modifier = Modifier
                .padding(50.dp,30.dp,20.dp, 10.dp)

        ) {
            Text("Hello World")


        }

    }
    @Preview(showBackground = true)
    @Composable
    fun modifierExample2(){
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(onClick = { clickaction() })

        ) {
            Text("Hello World")


        }
    }
    fun clickaction(){
        println("Column Clicked")
    }
    @Preview(showBackground = true)
    @Composable
    fun modifierExample3(){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Black)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            TextComposable(" 1")
            TextComposable(" 2")
            TextComposable(" 3")
            TextComposable(" 4")
        }
    }
}

