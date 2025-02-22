package com.dmitrysukhov.coffeeshop


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(
  viewModel: CoffeeViewModel,
    setTopBarState: (TopBarState) -> Unit, navController: NavHostController
) {
    LaunchedEffect(Unit) {
        setTopBarState(TopBarState(title = "") {
            TopBarIcon(iconRes = R.drawable.arrow) { navController.navigateUp() }
            TopBarIcon(iconRes = R.drawable.fav) {}
        })
    }
    val coffee = viewModel.selectedItem as? Coffee
    val bean = viewModel.selectedItem as? Beans
    Column(
        Modifier
            .fillMaxSize()
            .background(Black)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(521.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = coffee?.imageRes ?: bean?.imageRes!!),
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
                Column(
                    Modifier.padding(start = 22.dp, top = 31.dp)
                ) {
                    Text(
                        coffee?.name ?: bean?.name!!, color = Color.White, fontSize = 20.sp,
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        coffee?.milkType ?: bean?.company!!, color = LightGrey, fontSize = 12.sp,
                        fontFamily = poppinsFontFamily, fontWeight = W400, lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(26.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "", tint = Orange
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            (coffee?.grade ?: bean?.grade!!).toString(),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            "(${coffee?.ratingsCount ?: bean?.ratingsCount!!})",
                            color = LightGrey,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W400,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
                Spacer(Modifier.weight(1F))
                Column(Modifier.padding(end = 20.dp)) {
                    Row(modifier = Modifier.padding(top = 19.dp)) {
                        Block(iconRes = R.drawable.coffee, text = "Bean")
                        Spacer(modifier = Modifier.width(20.dp))
                        Block(iconRes = R.drawable.geo, text = "Africa")
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier
                            .size(width = 130.dp, height = 44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(VeryDarkGrey),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Medium Roasted",
                            color = LightGrey, fontFamily = poppinsFontFamily,
                            fontWeight = W500, fontSize = 10.sp, lineHeight = 20.sp
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.description), modifier = Modifier.padding(horizontal = 19.dp),
            color = LightGrey, fontWeight = W600, fontFamily = poppinsFontFamily
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            color = Color.White, fontFamily = poppinsFontFamily, fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 19.dp),
            text = coffee?.description ?: bean?.description!!
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.size), modifier = Modifier.padding(horizontal = 19.dp), color = LightGrey,
            fontWeight = W600, fontFamily = poppinsFontFamily
        )
        Spacer(modifier = Modifier.height(12.dp))
        var selectedOption by rememberSaveable { mutableStateOf(1) }
        val context = LocalContext.current
        ThreeButtonsPanel(
            if (coffee != null) "S" else "250gm",
            if (coffee != null) "M" else "500gm",
            if (coffee != null) "L" else "1000gm",
            selectedOption,

        ) { selectedOption = it }
        Spacer(modifier = Modifier.height(28.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.price), modifier = Modifier.padding(start = 40.dp), color = LightGrey,
                    fontWeight = W500, fontFamily = poppinsFontFamily,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFD17842))) {
                            append("$ ")
                        }
                        withStyle(style = SpanStyle(color = Color.White)) {
                            val price = coffee?.price ?: bean?.price!!
                            val newPrice = if (selectedOption == 3) price * 4 else
                                if (selectedOption == 2) price * 2 else price
                            append(newPrice.toString())
                        }
                    },
                    modifier = Modifier.padding(start = 20.dp), fontSize = 20.sp,
                    fontWeight = FontWeight.Bold, fontFamily = poppinsFontFamily,
                )
            }
            Button(
                onClick = {Toast.makeText(context, context.getString(R.string.added_to_cart), Toast.LENGTH_LONG).show() }, modifier = Modifier
                    .width(240.dp)
                    .height(60.dp)
                    .padding(end = 20.5.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = Orange, contentColor = Color.White
                ), shape = RoundedCornerShape(16.dp)
            ) {
                Text(

                    text = stringResource(id = R.string.add_to_cart), fontSize = 16.sp, fontWeight = FontWeight.Bold,

                    textAlign = TextAlign.Center, style = TextStyle(
                        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold

                    )
                )
            }
        }
        Spacer(Modifier.height(100.dp))
    }
}

const val DETAILS_SCREEN = "DetailsScreen"

@Composable
fun Block(iconRes: Int, text: String) {
    Column(
        modifier = Modifier
            .size(55.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(VeryDarkGrey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(20.dp), painter = painterResource(id = iconRes),
            contentDescription = null, tint = Orange
        )
        Text(
            text = text, color = LightGrey, fontFamily = poppinsFontFamily,
            fontSize = 10.sp, lineHeight = 20.sp, fontWeight = W500
        )
    }
}

@Composable
fun ThreeButtonsPanel(
    option1: String, option2: String, option3: String, selectedOption: Int,
    onSelect: (Int) -> Unit
) {
    Row(Modifier.padding(horizontal = 20.dp)) {
        OptionButton(Modifier.weight(1f), option1, selectedOption == 1) { onSelect(1) }
        Spacer(Modifier.width(25.dp))
        OptionButton(Modifier.weight(1f), option2, selectedOption == 2) { onSelect(2) }
        Spacer(Modifier.width(25.dp))
        OptionButton(Modifier.weight(1f), option3, selectedOption == 3) { onSelect(3) }
    }
}

@Composable
fun OptionButton(modifier: Modifier, text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(2.dp, if (isSelected) Orange else VeryDarkGrey, RoundedCornerShape(10.dp))
            .background(VeryDarkGrey)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            color = if (isSelected) Orange else LightGrey,
            fontFamily = poppinsFontFamily,
            fontWeight = W500,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}