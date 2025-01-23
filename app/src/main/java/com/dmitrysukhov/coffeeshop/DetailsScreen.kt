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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(onClick: () -> Unit) {
    //todo 1. сделать макет по дизайну
    //todo 2. сделать вьюмодель, ложить в нее выбранный элемент
    //todo 3. доставать его тут и наполнить реальными данными экран
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(521.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.beans_2),
                contentDescription = null
            )
            Row {

            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(121.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {

        }
    }


    Column(
        Modifier
            .fillMaxSize()
            .background(Black)
    )

    {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(521.dp)

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.beans_2),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(149.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .align(Alignment.BottomEnd)
            ) {
                Column(
                    Modifier.padding(start = 22.dp, top = 31.dp)
                ) {
                    Text(
                        "Robusta Beans",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "From Africa",
                        color = LightGrey,
                        fontSize = 12.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W400,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(26.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "",
                            tint = Orange
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            "4.5",
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            "(6,879)",
                            color = LightGrey,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W400,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
                Spacer(Modifier.weight(1F))
                Column(Modifier.padding(end = 20.dp)) {
                    Row(modifier = Modifier.padding(top = 19.dp)) {
                        Block(iconRes = R.drawable.coffee, text = "Bean")
                        Spacer(modifier = Modifier.width(20.dp))
                        Block(iconRes = R.drawable.geo, text = "Africa")

                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier
                            .size(width = 130.dp, height = 44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(VeryDarkGrey),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Medium Roasted",
                            color = LightGrey,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Description", modifier = Modifier.padding(horizontal = 19.dp), color = LightGrey, fontWeight = W600, fontFamily = poppinsFontFamily)
        Spacer(modifier = Modifier.height(15.dp))
        Text(color = Color.White,  fontFamily = poppinsFontFamily,modifier = Modifier.padding(horizontal = 19.dp),text = "Arabica beans are by far the most popular type of coffee beans, making up about 60% of the world’s coffee. These tasty beans originated many centuries ago in the highlands of Ethiopia, and may even be the first coffee beans ever consumed! ")
        Spacer(modifier = Modifier.height(15.dp))

        Button(

            onClick = onClick,
            modifier = Modifier
                .width(240.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange, contentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}

const val DETAILS_SCREEN = "DetailsScreen"

@Preview
@Composable
fun Preview() {
    DetailsScreen {}
}

@Composable
fun Block(iconRes: Int, text: String) {
    Column(

        modifier = Modifier
            .size(55.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(VeryDarkGrey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Orange
        )
        Text(
            text = text,
            color = LightGrey,
            fontFamily = poppinsFontFamily,
            fontSize = 10.sp,
            lineHeight = 20.sp,
            fontWeight = W500
        )
    }
}




