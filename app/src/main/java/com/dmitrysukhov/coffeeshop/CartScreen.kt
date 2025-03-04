import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dmitrysukhov.coffeeshop.Black
import com.dmitrysukhov.coffeeshop.DarkGrey2
import com.dmitrysukhov.coffeeshop.LightGrey
import com.dmitrysukhov.coffeeshop.Orange
import com.dmitrysukhov.coffeeshop.PAYMENT_SCREEN
import com.dmitrysukhov.coffeeshop.R
import com.dmitrysukhov.coffeeshop.TopBarIcon
import com.dmitrysukhov.coffeeshop.TopBarState
import com.dmitrysukhov.coffeeshop.VeryDarkGrey
import com.dmitrysukhov.coffeeshop.poppinsFontFamily


@Composable
fun CartScreen(setTopBarState: (TopBarState) -> Unit, navController: NavHostController) {
    LaunchedEffect(Unit) {
        setTopBarState(TopBarState(title = "Cart") {
            TopBarIcon(iconRes = R.drawable.kartochka) {}
            TopBarIcon(imgRes = R.drawable.man) {}
        })
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Black)
            .padding(top = 55.dp),
                verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
            Column(
                modifier = Modifier
                    .width(330.dp)
                    .height(255.dp)
                    .clip(RoundedCornerShape(23.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                            start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                        )
                    )
                    .padding(12.dp),
                ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.coffee_1),
                        contentDescription = null, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(23.dp))
                            .width(100.dp)
                            .height(100.dp)


                    )
                    Spacer(modifier = Modifier.width(22.dp))

                    Column {
                        Text(
                            text = "Cappuccino", color = Color.White, fontSize = 16.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )

                        Text(
                            text = "With Steamed Milk", color = Color.LightGray, fontSize = 10.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))

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
                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "S",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "M",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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

                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "L",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .width(330.dp)
                    .height(154.dp)
                    .clip(RoundedCornerShape(23.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                            start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                        )
                    )
                    .padding(12.dp),

                ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.coffee_2),
                        contentDescription = null, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(23.dp))
                            .width(126.dp)
                            .height(126.dp)


                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Column {
                        Text(
                            text = "Cappuccino", color = Color.White, fontSize = 16.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )

                        Text(
                            text = "With Steamed Milk", color = Color.LightGray, fontSize = 10.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier =
                                Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color.Black)
                                    .width(72.dp)
                                    .height(35.dp)
                            ) {
                                Text(
                                    text = "M",
                                    modifier = Modifier.align(Alignment.Center),
                                    color = Color.White,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = W500,
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(22.dp))
                            Text(
                                text = "$ ",
                                modifier = Modifier.padding(0.dp),
                                color = Orange,
                                fontFamily = poppinsFontFamily,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            )
                            Text(
                                text = "6.20",
                                modifier = Modifier
                                    .width(49.dp),
                                color = Color.White,
                                fontFamily = poppinsFontFamily,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(7.dp))
                                    .size(28.dp)
                                    .background(Orange)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.minus),
                                    contentDescription = "minus", modifier = Modifier
                                        .size(8.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(25.dp))
                            Box(
                                modifier =
                                Modifier
                                    .clip(RoundedCornerShape(7.dp))
                                    .background(color = Color.Black)
                                    .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                                    .width(50.dp)
                                    .height(30.dp)
                            )
                            {
                                Text(
                                    text = "1",
                                    modifier = Modifier.align(Alignment.Center),
                                    color = Color.White,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = W600,
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(25.dp))
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
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .width(330.dp)
                    .height(154.dp)
                    .clip(RoundedCornerShape(23.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                            start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                        )
                    )
                    .padding(12.dp),

                ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.beans_2),
                        contentDescription = null, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(23.dp))
                            .width(126.dp)
                            .height(126.dp)


                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Column {
                        Text(
                            text = "Cappuccino", color = Color.White, fontSize = 16.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Text(
                            text = "With Steamed Milk", color = Color.LightGray, fontSize = 10.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier =
                                Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color.Black)
                                    .width(72.dp)
                                    .height(35.dp)
                            ) {
                                Text(
                                    text = "250gm",
                                    modifier = Modifier.align(Alignment.Center),
                                    color = Color.LightGray,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = W500,
                                    fontSize = 10.sp,
                                    lineHeight = 20.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(22.dp))
                            Text(
                                text = "$ ",
                                modifier = Modifier.padding(0.dp),
                                color = Orange,
                                fontFamily = poppinsFontFamily,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            )
                            Text(
                                text = "6.20",
                                modifier = Modifier
                                    .width(49.dp),
                                color = Color.White,
                                fontFamily = poppinsFontFamily,
                                fontWeight = W600,
                                fontSize = 16.sp,
                                lineHeight = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(7.dp))
                                    .size(28.dp)
                                    .background(Orange)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.minus),
                                    contentDescription = "minus", modifier = Modifier
                                        .size(8.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(25.dp))
                            Box(
                                modifier =
                                Modifier
                                    .clip(RoundedCornerShape(7.dp))
                                    .background(color = Color.Black)
                                    .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                                    .width(50.dp)
                                    .height(30.dp)
                            )
                            {
                                Text(
                                    text = "1",
                                    modifier = Modifier.align(Alignment.Center),
                                    color = Color.White,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = W600,
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(25.dp))
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

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier

                    .width(330.dp)
                    .height(255.dp)
                    .clip(RoundedCornerShape(23.dp))


                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(DarkGrey2, DarkGrey2.copy(0.0f)),
                            start = Offset(0f, 0f), end = Offset(1000f, 1000f)
                        )
                    )
                    .padding(12.dp),
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.beans_1),
                        contentDescription = null, contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(23.dp))
                            .width(100.dp)
                            .height(100.dp)
                    )
                    Spacer(modifier = Modifier.width(22.dp))
                    Column {
                        Text(
                            text = "Cappuccino", color = Color.White, fontSize = 16.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Text(
                            text = "With Steamed Milk", color = Color.LightGray, fontSize = 10.sp,
                            fontFamily = poppinsFontFamily, lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
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
                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "250gm",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.LightGray,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "500gm",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Black)
                            .width(72.dp)
                            .height(35.dp)
                    ) {
                        Text(
                            text = "1Kg",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.LightGray,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W500,
                            fontSize = 10.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = "$ ",
                        modifier = Modifier.padding(0.dp),
                        color = Orange,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Text(
                        text = "4.20",
                        modifier = Modifier
                            .width(49.dp),
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = W600,
                        fontSize = 16.sp,
                        lineHeight = 20.sp
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .size(28.dp)
                            .background(Orange)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "minus", modifier = Modifier
                                .size(8.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
                    Box(
                        modifier =
                        Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(color = Color.Black)
                            .border(2.dp, (Orange), RoundedCornerShape(7.dp))
                            .width(50.dp)
                            .height(30.dp)
                    )
                    {
                        Text(
                            text = "1",
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = W600,
                            fontSize = 16.sp,
                            lineHeight = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(17.dp))
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
        Button(
            onClick = { navController.navigate(PAYMENT_SCREEN) }, modifier = Modifier
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
   Spacer(Modifier.height(100.dp))


    }
}

const val CART_SCREEN = "CartScreen"







