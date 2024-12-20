package com.dmitrysukhov.coffeeshop

import CART_SCREEN
import CartScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        title = NOTIFICATIONS_SCREEN,
                        selectedIcon = Icons.Filled.Notifications,
                        unselectedIcon = Icons.Default.Notifications
                    )
                )

                Scaffold(
                    topBar = {
                        Row(
                            Modifier
                                .background(Color.DarkGray)
                                .fillMaxWidth()
                                .padding(
                                    top = WindowInsets.systemBars
                                        .asPaddingValues()
                                        .calculateTopPadding()
                                )
                                .height(56.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                        }
                    },
                    bottomBar = {

                        NavigationBar(containerColor = Color.Black, contentColor = Color.Gray) {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItemIndex == index,
                                    onClick = {
                                        selectedItemIndex = index
                                        navController.navigate(item.title) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (selectedItemIndex == index) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = null,
                                            tint = if (selectedItemIndex == index) {
                                                Color(0xFFFFA500)
                                            } else Color.Gray
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HOME_SCREEN,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(HOME_SCREEN) { HomeScreen() }
                        composable(CART_SCREEN) { CartScreen() }
                        composable(FAVORITES_SCREEN) { FavoritesScreen() }
                        composable(NOTIFICATIONS_SCREEN) { NotificationsScreen() }
                        composable(DETAILS_SCREEN) { DetailsScreen(onClick = { }) }
                        composable(ORDER_HISTORY_SCREEN) { OrderHistoryScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun FavoritesScreen() {
}

@Composable
fun NotificationsScreen() {
}

const val FAVORITES_SCREEN = "FavoritesScreen"
const val NOTIFICATIONS_SCREEN = "NotificationsScreen"