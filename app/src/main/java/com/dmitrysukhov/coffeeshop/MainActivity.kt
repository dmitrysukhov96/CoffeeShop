package com.dmitrysukhov.coffeeshop

import CART_SCREEN
import CartScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmitrysukhov.coffeeshop.ui.theme.CoffeeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeShopTheme {
                val navController = rememberNavController()
                var selectedItemIndex by remember { mutableStateOf(0) }

                val items = listOf(
                    BottomNavItem(
                        title = HOME_SCREEN,
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        title = CART_SCREEN,
                        selectedIcon = Icons.Filled.ShoppingCart,
                        unselectedIcon = Icons.Default.ShoppingCart
                    ),
                    BottomNavItem(
                        title = FAVORITES_SCREEN,
                        selectedIcon = Icons.Filled.Favorite,
                        unselectedIcon = Icons.Default.FavoriteBorder
                    ),
                    BottomNavItem(
                        title = ORDER_HISTORY_SCREEN,
                        selectedIcon = Icons.Filled.Notifications,
                        unselectedIcon = Icons.Default.Notifications
                    )
                )

                Scaffold(
                    topBar = {
                        //todo сделать такой топБар как в дизайне
                    },
                    bottomBar =
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(23.dp))
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFF262B33), Color(0x00262B33)),
                                        start = Offset(0f, 0f),
                                        end = Offset(1000f, 1000f)
                                    )
                                )
                                .height(89.dp)
                                .padding(horizontal = 41.dp),
                            verticalAlignment = Alignment.CenterVertically
                            , horizontalArrangement = Arrangement.SpaceBetween


                        ) {

                            Icon(painter = painterResource(R.drawable.home) , contentDescription = null)
                            Icon(painter = painterResource(R.drawable.shop) , contentDescription = null)
                            Icon(painter = painterResource(R.drawable.fav) , contentDescription = null)
                            Icon(painter = painterResource(R.drawable.col) , contentDescription = null)
                        }


                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HOME_SCREEN,
                        modifier = Modifier.background(Color(0xFF0C0F14))
                    ) {
                        composable(HOME_SCREEN) { HomeScreen() }
                        composable(CART_SCREEN) { CartScreen() }
                        composable(FAVORITES_SCREEN) { FavouritesScreen() }
                        composable(DETAILS_SCREEN) { DetailsScreen(onClick = { }) }
                        composable(ORDER_HISTORY_SCREEN) { OrderHistoryScreen() }
                    }
                }
            }
        }
    }
}



