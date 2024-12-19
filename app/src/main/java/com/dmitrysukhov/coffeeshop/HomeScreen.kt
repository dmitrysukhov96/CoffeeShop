package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C0F14))
            .padding(start = 30.dp)
    )
    {
        Spacer(Modifier.height(60.dp))
//        LazyRow = строка элементов
//        LazyColumn = колонка элементов (столбик)


        LazyRow {
            items(beansList) { bean ->
                ListItem(bean)
                Spacer(Modifier.width(22.dp))
            }
        }
    }
}

@Composable
fun ListItem(bean: Beans) {
    Column(
        modifier = Modifier
            .width(149.dp)
            .height(245.dp)
            .clip(RoundedCornerShape(23.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF262B33), Color(0x00262B33)),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                )
            )
            .padding(12.dp)
    ) {
        Spacer(Modifier.height(13.dp))
        Image(
            painter = painterResource(bean.imageRes),
            contentDescription = "Coffee Beans", modifier = Modifier
                .size(126.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(10.dp))
        Text(
            bean.name, color = Color.White, fontSize = 13.sp, fontFamily = poppinsFontFamily,
            lineHeight = 20.sp, maxLines = 1
        )
        Text(
            bean.roastLevel, color = Color.White, fontSize = 9.sp, fontFamily = poppinsFontFamily,
            lineHeight = 20.sp
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("$ ", color = Orange, fontFamily = poppinsFontFamily, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            Text(bean.price.toString(), color = Color.White, fontFamily = poppinsFontFamily, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Orange)
            ) {
                Image(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = "plus",
                    modifier = Modifier
                        .size(8.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previewshka() {
    HomeScreen()
}

val Orange = Color(0xFFD17842)