package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
     Column (
         modifier = Modifier
             .fillMaxSize()
             .padding(top = 120.dp, start = 30.dp, end = 165.dp)
             .width(195.dp)
             .height(72.dp)
     ) {
         Text(
             text = "Find the best\n" +
                     "coffee for you",
             color = Color.White,
             fontSize = 28.sp,
             fontWeight = FontWeight.W600,
             fontFamily = poppinsFontFamily
         )
     }
 }
const val  HOME_SCREEN = "HomeScreen"