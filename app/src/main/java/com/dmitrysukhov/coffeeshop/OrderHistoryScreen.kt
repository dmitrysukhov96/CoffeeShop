  package com.dmitrysukhov.coffeeshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

  @Composable

fun OrderHistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C0F14))
    )
    {
        Text(text = "OrderHistoryScreen")

    }
}

  const val ORDER_HISTORY_SCREEN = "OrderHistoryScreen"