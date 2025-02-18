package com.rick.workclass.ejemplo.com.example.example1.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.example1.R
@Composable
 fun TestScreen(navController: NavHostController) {

     Column () {
         Column() {
             TextComposable("Miguel")
             TextComposable()
             TextComposable()
             TextComposable()
         }
         Column() {
             modifierExample2()
             modifierExample4()
             Customtext()
             picture()

         }
     }
 }

     @Preview(showBackground = true)
     @Composable
     fun TextComposable(name: String = "Empty") {
         Text("Welcome ")
         Text(name)
     }

     @Preview(showBackground = true)
     @Composable
     fun modifierExample1() {
         Column(
             modifier = Modifier
                 .padding(50.dp, 30.dp, 20.dp, 10.dp)

         ) {
             Text("Hello World")


         }

     }

     @Preview(showBackground = true)
     @Composable
     fun modifierExample2() {
         Column(
             modifier = Modifier
                 .padding(24.dp)
                 .fillMaxWidth()
                 .clickable(onClick = { clickaction() })

         ) {
             Text("Hello World")


         }
     }

     fun clickaction() {
         println("Column Clicked")
     }

     @Preview(showBackground = true)
     @Composable
     fun modifierExample3() {
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

     @Preview(showBackground = true)
     @Composable
     fun modifierExample4() {
         Box(
             modifier = Modifier
                 .padding(10.dp)
                 .width(300.dp)
                 .height(300.dp)
                 .background(Color.Gray)

         ) {
             Text("1", Modifier.align(Alignment.TopStart))
             Text("2", Modifier.align(Alignment.TopCenter))
             Text("3", Modifier.align(Alignment.TopEnd))
             Text("4", Modifier.align(Alignment.CenterStart))
             Text("5", Modifier.align(Alignment.Center))
             Text("6", Modifier.align(Alignment.CenterEnd))
             Text("7", Modifier.align(Alignment.BottomStart))
             Text("8", Modifier.align(Alignment.BottomCenter))
             Text("9", Modifier.align(Alignment.BottomEnd))

         }


     }

     @Preview(showBackground = true)
     @Composable
     fun Customtext() {
         Column() {
             Text(
                 stringResource(R.string.example_text),
                 color = colorResource(R.color.purple_700),
                 fontSize = 20.sp,
                 fontStyle = FontStyle.Italic,
                 fontWeight = FontWeight.W700
             )
             val gradientcolors =
                 listOf(Color.Cyan, Color.DarkGray, colorResource(R.color.purple_700))
             Text(
                 stringResource(R.string.example_text),
                 style = TextStyle(brush = Brush.linearGradient(colors = gradientcolors))
             )
         }

     }

     @Preview(showBackground = true)
     @Composable
     fun picture() {
         Column(
             modifier = Modifier
                 .fillMaxWidth()
                 .background(Color.Black)
                 .height(300.dp)

         ) {
             Image(
                 modifier = Modifier
                     .fillMaxWidth(),
                 painter = painterResource(R.drawable.autos),
                 contentDescription = "Logo Autos",
                 contentScale = ContentScale.FillHeight

             )

         }
     }
