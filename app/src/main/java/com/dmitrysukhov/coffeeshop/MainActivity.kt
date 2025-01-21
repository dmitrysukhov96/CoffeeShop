package com.dmitrysukhov.coffeeshop

import CART_SCREEN
import CartScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmitrysukhov.coffeeshop.ui.theme.CoffeeShopTheme
import com.dmitrysukhov.coffeeshop.ui.theme.SPLASH_SCREEN
import com.dmitrysukhov.coffeeshop.ui.theme.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeShopTheme {
                val navController = rememberNavController()
                var showToolbar by rememberSaveable { mutableStateOf(false) }
                Scaffold(
                    topBar = {
                        // TODO: Сделать такой топБар как в дизайне
                    },
                    bottomBar = {
                        var selectedItem by rememberSaveable { mutableStateOf(HOME_SCREEN) }
                        AnimatedVisibility(showToolbar, enter = EnterTransition.None) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(23.dp))
                                    .background(Black)
                                    .height(89.dp)
                                    .padding(horizontal = 41.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.home),
                                    contentDescription = null,
                                    tint = if (selectedItem == HOME_SCREEN) Orange else Grey2,
                                    modifier = Modifier.clickable {
                                        selectedItem = HOME_SCREEN
                                        navController.navigate(HOME_SCREEN)
                                    }
                                )
                                Icon(
                                    painter = painterResource(R.drawable.shop),
                                    contentDescription = null,
                                    tint = if (selectedItem == CART_SCREEN) Orange else Grey2,
                                    modifier = Modifier.clickable {
                                        selectedItem = CART_SCREEN
                                        navController.navigate(CART_SCREEN)
                                    }
                                )
                                Icon(
                                    painter = painterResource(R.drawable.fav),
                                    contentDescription = null,
                                    tint = if (selectedItem == FAVORITES_SCREEN) Orange else Grey2,
                                    modifier = Modifier.clickable {
                                        selectedItem = FAVORITES_SCREEN
                                        navController.navigate(FAVORITES_SCREEN)
                                    }
                                )
                                Icon(
                                    painter = painterResource(R.drawable.col),
                                    contentDescription = null,
                                    tint = if (selectedItem == ORDER_HISTORY_SCREEN) Orange else Grey2,
                                    modifier = Modifier.clickable {
                                        selectedItem = ORDER_HISTORY_SCREEN
                                        navController.navigate(ORDER_HISTORY_SCREEN)
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = SPLASH_SCREEN,
                        modifier = Modifier.background(Black)
                    ) {
                        composable(SPLASH_SCREEN) {
                            SplashScreen(onTimeout = {
                                navController.navigate(HOME_SCREEN) {
                                    popUpTo(SPLASH_SCREEN) { inclusive = true }
                                    showToolbar = true
                                }
                            })
                        }
                        composable(HOME_SCREEN) { HomeScreen() }
                        composable(CART_SCREEN) { CartScreen() }
                        composable(FAVORITES_SCREEN) { FavouritesScreen() }
                        composable(DETAILS_SCREEN) { DetailsScreen(onClick = { }) }
                        composable(ORDER_HISTORY_SCREEN) { OrderHistoryScreen() }
                        composable(DETAILS_SCREEN) { DetailsScreen(onClick = {}) }
                    }
                }
            }
        }
    }
}




