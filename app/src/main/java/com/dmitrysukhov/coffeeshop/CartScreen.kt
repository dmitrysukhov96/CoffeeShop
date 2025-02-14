import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dmitrysukhov.coffeeshop.Black
import com.dmitrysukhov.coffeeshop.R
import com.dmitrysukhov.coffeeshop.TopBarIcon
import com.dmitrysukhov.coffeeshop.TopBarState

@Composable

fun CartScreen(setTopBarState: (TopBarState) -> Unit) {
    LaunchedEffect(Unit) {
        setTopBarState(TopBarState(title = "Cart") {
            TopBarIcon(iconRes = R.drawable.kartochka) {}
            TopBarIcon(imgRes = R.drawable.man) {}
        })
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "CartScreen", color = Color.White)
    }
}

const val CART_SCREEN = "CartScreen"


