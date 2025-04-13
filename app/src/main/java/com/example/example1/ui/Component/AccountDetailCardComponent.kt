package com.rick.workclass.ejemplo.com.example.example1.ui.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.example1.R

@Composable
fun AccountDetailCardComponent(
    id:Int,
    name:String,
    username:String,
    password:String,
    imageURL:String?,
    description:String,
    onSaveClick: () -> Unit,
    navController:NavController
){
  Column (){
      Row (modifier = Modifier
          .fillMaxWidth()
          .height(200.dp)
          .padding(10.dp),
         // Arrangement.Absolute.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Absolute.Center
      ){
          AsyncImage(
              modifier = Modifier
                  .width(130.dp)
                  .height(130.dp),
              model = imageURL,
              contentScale = ContentScale.FillBounds,
              contentDescription = "Account logo",
              error = painterResource(R.drawable.ted),
          )
              Column(
                  //modifier = Modifier.padding(30.dp),
                  verticalArrangement = Arrangement.SpaceBetween,
                  horizontalAlignment = Alignment.CenterHorizontally
              ){
                  Text(modifier = Modifier.padding(10.dp),
                      text= name,
                      fontSize = 40.sp,
                      fontWeight = FontWeight.ExtraBold)

                  Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                      IconButton (
                          onClick = {
                              onSaveClick()
                          },
                      ) {
                          Icon(
                              imageVector = Icons.Filled.Favorite,
                              contentDescription = "Add",
                              Modifier.size(60.dp)
                                  .padding(10.dp)
                          )
                      }
                      IconButton(
                          onClick = {
                              navController.navigate("manageAcScreen/${id}")
                          }
                      ) {
                          Icon(imageVector = Icons.Filled.Edit, contentDescription = "Update",
                          modifier = Modifier .size(38.dp))
                      }
                  }
              }
          }
      androidx.compose.material.Text(
          modifier = Modifier.padding(11.dp),
          text = username,
          fontSize = 25.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
      )
      androidx.compose.material.Text(
          modifier = Modifier.padding(11.dp),
          text = password,
          fontSize = 25.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
      )
      androidx.compose.material.Text(
          modifier = Modifier.padding(11.dp),
          text = description,
          fontSize = 25.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White
      )



      }

  }
