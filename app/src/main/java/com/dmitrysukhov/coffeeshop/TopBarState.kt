package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class TopBarState(
    val title: String = "", val topBarActions: (@Composable RowScope.() -> Unit) = {}
)

@Composable
fun TopBarIcon(iconRes: Int? = null, imgRes: Int? = null, onClick: () -> Unit) {
    Box(
        Modifier
            .size(30.dp)
            .clickable { onClick() }
            .background(brush = Brush.linearGradient(listOf(DarkGrey2, Black)),
                RoundedCornerShape(10.dp)
            )
            .border(1.dp, Color(0xFF21262E), RoundedCornerShape(10.dp))
    ) {
        iconRes?.let {
            Icon(
                painterResource(iconRes), contentDescription = null, tint = Grey,
                modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.Center),
            )
        }
        imgRes?.let {
            Image(
                painter = painterResource(imgRes), contentDescription = null,
                modifier = Modifier.fillMaxSize().clip( RoundedCornerShape(10.dp)), contentScale = ContentScale.Crop
            )
        }
    }
}