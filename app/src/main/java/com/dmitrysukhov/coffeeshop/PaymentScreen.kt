package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PaymentScreen(setTopBarState: (TopBarState) -> Unit, navController: NavHostController) {
    LaunchedEffect(Unit) {
        setTopBarState(TopBarState(title = "Payment") {
            TopBarIcon(iconRes = R.drawable.arrow) { navController.navigateUp() }
        })
    }
    Column (Modifier.fillMaxSize()){
        Spacer(Modifier.height(100.dp))
        Column(
            Modifier
                .padding(horizontal = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                        start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                    )
                )
                .height(186.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Row {
                Icon(
                    painter = painterResource(R.drawable.chip),
                    contentDescription = null,
                    tint = Orange,
                    modifier = Modifier.size(width = 31.dp, height = 24.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.visa),
                    contentDescription = null,
                    modifier = Modifier.size(width = 50.dp, height = 16.15.dp)

                )
            }
        }
    }


}


const val PAYMENT_SCREEN = "PaymentScreen"