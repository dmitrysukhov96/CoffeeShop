package com.dmitrysukhov.coffeeshop


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(onClick: () -> Unit) {

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
                Column { Text("Robusta Beans", color = Color.White) }
                Column {  }
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
        Button(
            onClick = onClick, modifier = Modifier
                .width(240.dp)
                .height(60.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Orange, contentColor = Color.White
            ), shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Add to Cart", fontSize = 16.sp, fontWeight = FontWeight.Bold,
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
    DetailsScreen {

    }
}





