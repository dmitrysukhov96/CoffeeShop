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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
            .background(Black)
            .padding(top = 120.dp, start = 30.dp)
    )
    {
        Text(
            text = "Find the best\n" +
                    "coffee for you",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.W600,
            fontFamily = poppinsFontFamily
        )
        Spacer(Modifier.height(60.dp))
//        LazyRow = строка элементов
//        LazyColumn = колонка элементов (столбик)

        LazyRow {
            items(coffeeList) { coffee ->
                ListItem2(coffee)
                Spacer(Modifier.width(22.dp))
            }
        }
        Text(
            text = "Coffee beans",
            color = Color.White,
            modifier = Modifier.padding(20.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = poppinsFontFamily,
        )

        LazyRow {
            items(beansList) { bean ->
                ListItem(bean)
                Spacer(Modifier.width(22.dp))
            }
        }


    }
}


@Composable
fun ListItem2(coffee: Coffee) {
    Box(
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

        Column {
            Spacer(Modifier.height(13.dp))
            Box(
                Modifier
                    .size(126.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(coffee.imageRes),
                    contentDescription = "Coffee", modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                Image(
                    painter = painterResource(R.drawable.oval),
                    contentDescription = "", modifier = Modifier.align(Alignment.TopEnd)
                    //.size(50.dp) это не работает
                )
                Row(
                    Modifier
                        .align(Alignment.TopEnd).padding(end = 11.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "", tint = Orange,
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = coffee.grade.toString(),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.W600,
                        lineHeight = 20.sp

                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                coffee.name, color = Color.White, fontSize = 13.sp, fontFamily = poppinsFontFamily,
                lineHeight = 20.sp, maxLines = 1
            )
            Text(
                coffee.roastLevel,
                color = Color.White,
                fontSize = 9.sp,
                fontFamily = poppinsFontFamily,
                lineHeight = 20.sp
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "$ ",
                    color = Orange,
                    fontFamily = poppinsFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    coffee.price.toString(),
                    color = Color.White,
                    fontFamily = poppinsFontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
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
            bean.roastLevel,
            color = Color.White,
            fontSize = 9.sp,
            fontFamily = poppinsFontFamily,
            lineHeight = 20.sp
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "$ ",
                color = Orange,
                fontFamily = poppinsFontFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                bean.price.toString(),
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
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

const val HOME_SCREEN = "HomeScreen"