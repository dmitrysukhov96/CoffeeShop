package com.dmitrysukhov.coffeeshop

import CART_SCREEN
import CartScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmitrysukhov.coffeeshop.ui.theme.CoffeeShopTheme
import com.dmitrysukhov.coffeeshop.ui.theme.SPLASH_SCREEN
import com.dmitrysukhov.coffeeshop.ui.theme.SplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var topBarState by remember { mutableStateOf(TopBarState()) }
            val setTopBarState: (TopBarState) -> Unit = { topBarState = it }
            val systemUiController = rememberSystemUiController()
            SideEffect { systemUiController.setStatusBarColor(color = Black, darkIcons = false) }
            CoffeeShopTheme {
                val viewModel:CoffeeViewModel = viewModel()
                val navController = rememberNavController()
                val hazeState = remember { HazeState() }
                var showBottomBar by rememberSaveable { mutableStateOf(false) }
                showBottomBar = navController.currentDestination?.route != DETAILS_SCREEN
                Scaffold(
                    topBar = {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .padding(horizontal = 22.dp)) {
                            Row(modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) { topBarState.topBarActions.invoke(this) }
                            Text(topBarState.title, color = Color.White, modifier =  Modifier.align(Alignment.Center))
                        }
                    },
                    bottomBar = {
                        var selectedItem by rememberSaveable { mutableStateOf(HOME_SCREEN) }
                        AnimatedVisibility(showBottomBar, enter = EnterTransition.None) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp))
                                    .height(89.dp)
                                    .then(
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                                            Modifier.hazeEffect(
                                                hazeState,
                                                style = HazeStyle(
                                                    backgroundColor = Color.Transparent,
                                                    tint = null, 30.dp
                                                )
                                            )
                                        } else Modifier.background(Black.copy(0.7f))
                                    )
                                    .padding(horizontal = 41.dp)
                                    .padding(
                                        bottom = WindowInsets.navigationBars.asPaddingValues()
                                            .calculateBottomPadding()
                                    ), verticalAlignment = Alignment.CenterVertically,
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
                        navController = navController, startDestination = SPLASH_SCREEN,
                        modifier = Modifier
                            .background(Black)
                            .hazeSource(hazeState)
                    ) {
                        composable(SPLASH_SCREEN) {
                            SplashScreen(onTimeout = {
                                navController.navigate(HOME_SCREEN) {
                                    popUpTo(SPLASH_SCREEN) { inclusive = true }
                                    showBottomBar = true
                                }
                            })
                        }
                        composable(HOME_SCREEN) {
                            HomeScreen(navController, viewModel, setTopBarState)
                        }
                        composable(CART_SCREEN) { CartScreen(setTopBarState) }
                        composable(FAVORITES_SCREEN) { FavouritesScreen() }
                        composable(DETAILS_SCREEN) {
                            DetailsScreen({ /*todo*/ }, viewModel, setTopBarState, navController)
                        }
                        composable(ORDER_HISTORY_SCREEN) { OrderHistoryScreen() }
                    }
                }
            }
        }
    }
}