package com.dmitrysukhov.coffeeshop


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedFilter by rememberSaveable { mutableStateOf("All") }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .verticalScroll(rememberScrollState())
            .padding(top = 120.dp, start = 30.dp)
    ) {
        Text(
            text = "Find the best\ncoffee for you", color = Color.White,
            fontSize = 28.sp, lineHeight = 36.sp, fontWeight = FontWeight.W600,
            fontFamily = poppinsFontFamily
        )
        Row(
            Modifier.padding(end = 30.dp, top = 28.dp, bottom = 28.dp)
        ) {
            TextField(
                value = searchQuery, maxLines = 1, textStyle = TextStyle(fontFamily = poppinsFontFamily),
                onValueChange = {
                    searchQuery = it
                    selectedFilter = "All"
                }, placeholder = {
                    Text(
                        text = "Find Your Coffee...", color = Grey, fontFamily = poppinsFontFamily,
                        fontSize = 10.sp, fontWeight = FontWeight.Medium
                    )
                }, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = VeryDarkGrey, focusedContainerColor = VeryDarkGrey,
                    focusedTextColor = Color.White, focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ), leadingIcon = {
                    Icon(painterResource(R.drawable.search), contentDescription = "Search",
                        tint = Grey)
                }, shape = RoundedCornerShape(15.dp), modifier = Modifier.fillMaxWidth()
            )
        }
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            Filter("All", isSelected = selectedFilter == "All", { selectedFilter = it })
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Cappuccino", isSelected = selectedFilter == "Cappuccino") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Espresso", isSelected = selectedFilter == "Espresso") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Americano", isSelected = selectedFilter == "Americano") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Macchiato", isSelected = selectedFilter == "Macchiato") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Latte", isSelected = selectedFilter == "Latte") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Mocha", isSelected = selectedFilter == "Mocha") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter(
                "Flat White", isSelected = selectedFilter == "Flat White"
            ) {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
            Filter("Ristretto", isSelected = selectedFilter == "Ristretto") {
                selectedFilter = it
                searchQuery = ""
            }
            Spacer(modifier = Modifier.width(19.dp))
        }
        Spacer(Modifier.height(22.dp))
        LazyRow {
            items(coffeeList.filter {
                ((selectedFilter == "All" && searchQuery == "") ||
                        it.name.contains(selectedFilter, ignoreCase = true)) ||
                        (searchQuery.isNotBlank() && it.name.contains(
                            searchQuery, ignoreCase = true))
            }) { coffee ->
                ListItem(coffee, {

                })
                Spacer(Modifier.width(22.dp))
            }
        }
        Text(
            text = "Coffee beans", color = Color.White, modifier = Modifier.padding(vertical = 20.dp),
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500, fontFamily = poppinsFontFamily)
        )
        LazyRow {
            items(beansList.filter {
                searchQuery.isBlank() ||
                (searchQuery.isNotBlank() && it.name.contains(
                    searchQuery, ignoreCase = true))
            }) { bean ->
                ListItem(bean, {
                    navController.navigate(DETAILS_SCREEN)
                })
                Spacer(Modifier.width(22.dp))
            }
        }
        Spacer(Modifier.height(89.dp))
        //todo сделать надпись ничего не найдено
        //todo локализации
    }
}

@Composable
fun ListItem(coffee: Any, onClick: () -> Unit) {
    val type = if (coffee is Coffee) "Drink" else "Beans"
    val drink = coffee as? Coffee
    val beans = coffee as? Beans
    Box(
        modifier = Modifier
            .width(149.dp)
            .height(245.dp)
            .clip(RoundedCornerShape(23.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF262B33), Color(0x00262B33)),
                    start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                )
            )
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Column {
            Spacer(Modifier.height(13.dp))
            Box(
                Modifier
                    .size(126.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                val res = if (type == "Drink") drink?.imageRes else beans?.imageRes
                if (res != null) Image(
                    painter = painterResource(res),
                    contentDescription = "Coffee", modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(R.drawable.oval),
                    contentDescription = "", modifier = Modifier.align(Alignment.TopEnd)
                )
                Row(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 11.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "", tint = Orange,
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    val grade =
                        (if (type == "Drink") drink?.grade?.toString() else beans?.grade?.toString())
                            ?: ""
                    Text(
                        text = grade, color = Color.White, fontSize = 10.sp, lineHeight = 20.sp,
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.W600

                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                drink?.name ?: beans?.name ?: "", color = Color.White, fontSize = 13.sp,
                fontFamily = poppinsFontFamily, lineHeight = 20.sp, maxLines = 1
            )
            Text(
                drink?.roastLevel ?: beans?.roastLevel ?: "", color = Color.White,
                fontSize = 9.sp, fontFamily = poppinsFontFamily, lineHeight = 20.sp
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "$ ", color = Orange, fontFamily = poppinsFontFamily, fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    drink?.price?.toString() ?: beans?.price?.toString() ?: "",
                    color = Color.White, fontFamily = poppinsFontFamily, fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(Orange)
                ) {
                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "plus", modifier = Modifier
                            .size(8.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun Filter(text: String, isSelected: Boolean, onSelect: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable(
            onClick = { onSelect(text) }, indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text, color = if (isSelected) Orange else Grey, fontWeight = FontWeight.SemiBold,
            fontFamily = poppinsFontFamily, fontSize = 14.sp
        )
        if (isSelected)
            Image(painter = painterResource(R.drawable.circle), contentDescription = null)
    }
}

const val HOME_SCREEN = "HomeScreen"