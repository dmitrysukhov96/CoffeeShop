package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier
            .width(240.dp)
            .height(60.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFD17842), contentColor = Color.White
        ), shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = "Add to Cart", fontSize = 16.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = TextStyle(fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold)
        )
    }
}