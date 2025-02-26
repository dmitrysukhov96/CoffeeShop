package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FavouritesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(2000) {
                CoffeeCart()
            }
        }
    }

}

@Composable
fun CoffeeCart() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                    start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                )
            )
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.coffee_1),
            contentDescription = "Coffee",
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp))

        )

        Spacer(modifier = Modifier.width(15.dp))

        Column {
            Text(
                text = "Cappuccino",
                color = Color.White,
                fontSize = 18.sp,
            )
            Text(
                text = "Neskafe",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

const val FAVORITES_SCREEN = "FavoritesScreen"
