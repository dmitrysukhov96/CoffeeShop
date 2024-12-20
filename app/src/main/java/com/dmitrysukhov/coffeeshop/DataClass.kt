package com.dmitrysukhov.coffeeshop

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector)

data class Coffee(
    var name: String,
    var price: Float,
    var milk: Boolean,
    var milkType: String,
    var description: String,
    var size: String,
    var grade: Float,
    var roastLevel: String,
    var ratingsCount: Int
)

data class Beans(
    var name: String,
    var roastLevel: String,
    var company: String,
    var price: Float,
    var description: String,
    var size: Long,
    var country: String,
    var grade: Float,
    var imageRes: Int
)




val beansList = listOf(
    Beans(
        name = "Arabica",
        roastLevel = "Medium",
        company = "Nescafe",
        price = 8.99f,
        description = "Fruity and sweet coffee with a smooth finish.",
        size = 250L,
        country = "Ethiopia",
        grade = 4.7f,
        imageRes = R.drawable.beans_2
    ),
    Beans(
        name = "Robusta",
        roastLevel = "Dark",
        company = "Starbucks",
        price = 7.49f,
        description = "Strong and earthy coffee with high caffeine content.",
        size = 500L,
        country = "Vietnam",
        grade = 4.3f,
        imageRes = R.drawable.beans_3
    ),
    Beans(
        name = "Colombian Supremo",
        roastLevel = "Medium-Dark",
        company = "Lavazza",
        price = 9.99f,
        description = "Rich and balanced with notes of chocolate and nuts.",
        size = 300L,
        country = "Colombia",
        grade = 4.8f,
        imageRes = R.drawable.beans_1
    ),
    Beans(
        name = "Brazilian Santos",
        roastLevel = "Light",
        company = "Jacobs",
        price = 8.49f,
        description = "Mild and nutty flavor with low acidity.",
        size = 250L,
        country = "Brazil",
        grade = 4.5f,
        imageRes = R.drawable.beans_4
    ),
    Beans(
        name = "Sumatra Mandheling",
        roastLevel = "Dark",
        company = "Tchibo",
        price = 10.99f,
        description = "Earthy and herbal coffee with a full body.",
        size = 400L,
        country = "Indonesia",
        grade = 4.6f,
        imageRes = R.drawable.beans_5
    ),
    Beans(
        name = "Ethiopian Yirgacheffe",
        roastLevel = "Light",
        company = "Carte Noire",
        price = 12.99f,
        description = "Delicate and floral coffee with citrus notes.",
        size = 250L,
        country = "Ethiopia",
        grade = 4.9f, imageRes = R.drawable.beans_6
    ),
    Beans(
        name = "Kenyan AA",
        roastLevel = "Medium",
        company = "Illy",
        price = 11.49f,
        description = "Bold and winey coffee with berry-like acidity.",
        size = 300L,
        country = "Kenya",
        grade = 4.8f, imageRes = R.drawable.beans_7
    ),
    Beans(
        name = "Guatemalan Antigua",
        roastLevel = "Medium-Dark",
        company = "Dolce Gusto",
        price = 9.99f,
        description = "Spicy and smoky coffee with a chocolatey finish.",
        size = 350L,
        country = "Guatemala",
        grade = 4.7f, imageRes = R.drawable.beans_8
    )
)








val coffeeList = listOf(
    Coffee(
        name = "Cappuccino",
        price = 4.50f,
        milk = true,
        milkType = "Whole",
        description = "A classic Italian coffee made with a shot of espresso, steamed milk, and a rich foam topping.",
        size = "Medium",
        grade = 4.7f,
        roastLevel = "Medium",
        ratingsCount = 1200
    ),
    Coffee(
        name = "Latte",
        price = 5.00f,
        milk = true,
        milkType = "Skim",
        description = "A creamy coffee beverage with a shot of espresso and steamed milk, topped with light foam.",
        size = "Large",
        grade = 4.5f,
        roastLevel = "Light",
        ratingsCount = 980
    ),
    Coffee(
        name = "Doppio",
        price = 3.20f,
        milk = false,
        milkType = "None",
        description = "A double shot of espresso for those who enjoy pure, strong coffee.",
        size = "Small",
        grade = 4.8f,
        roastLevel = "Dark",
        ratingsCount = 540
    ),
    Coffee(
        name = "Mocha",
        price = 5.30f,
        milk = true,
        milkType = "Almond",
        description = "A delightful blend of espresso, steamed milk, and chocolate syrup, topped with whipped cream.",
        size = "Large",
        grade = 4.6f,
        roastLevel = "Medium",
        ratingsCount = 700
    ),
    Coffee(
        name = "Americano",
        price = 2.90f,
        milk = false,
        milkType = "None",
        description = "A simple yet bold drink, made by diluting a shot of espresso with hot water.",
        size = "Medium",
        grade = 4.2f,
        roastLevel = "Medium",
        ratingsCount = 800
    ),
    Coffee(
        name = "Flat White",
        price = 4.80f,
        milk = true,
        milkType = "Oat",
        description = "A rich and creamy coffee with a perfect balance of espresso and micro-foamed milk.",
        size = "Medium",
        grade = 4.7f,
        roastLevel = "Light",
        ratingsCount = 650
    ),
    Coffee(
        name = "Espresso",
        price = 2.50f,
        milk = false,
        milkType = "None",
        description = "A single shot of intense and flavorful coffee, perfect for a quick pick-me-up.",
        size = "Small",
        grade = 4.9f,
        roastLevel = "Dark",
        ratingsCount = 1000
    ),
    Coffee(
        name = "Macchiato",
        price = 3.80f,
        milk = true,
        milkType = "Whole",
        description = "An espresso marked with a dollop of steamed milk for a balanced flavor.",
        size = "Small",
        grade = 4.3f,
        roastLevel = "Medium",
        ratingsCount = 520
    ),
    Coffee(
        name = "Ristretto",
        price = 2.80f,
        milk = false,
        milkType = "None",
        description = "A short shot of espresso with a more intense flavor profile.",
        size = "Small",
        grade = 4.8f,
        roastLevel = "Dark",
        ratingsCount = 600
    ),
    Coffee(
        name = "Cortado",
        price = 3.50f,
        milk = true,
        milkType = "Whole",
        description = "An espresso cut with a small amount of steamed milk, creating a smooth and balanced taste.",
        size = "Small",
        grade = 4.6f,
        roastLevel = "Medium",
        ratingsCount = 450
    ),
    Coffee(
        name = "Affogato",
        price = 5.00f,
        milk = true,
        milkType = "None",
        description = "A luxurious dessert coffee with a shot of espresso poured over vanilla ice cream.",
        size = "Small",
        grade = 4.9f,
        roastLevel = "Dark",
        ratingsCount = 550
    ),
    Coffee(
        name = "Irish Coffee",
        price = 6.50f,
        milk = true,
        milkType = "Cream",
        description = "A warming coffee drink with whiskey, sugar, and cream, perfect for cold days.",
        size = "Medium",
        grade = 4.5f,
        roastLevel = "Medium",
        ratingsCount = 320
    ),
    Coffee(
        name = "Turkish Coffee",
        price = 3.00f,
        milk = false,
        milkType = "None",
        description = "A traditional coffee prepared with finely ground beans, water, and sugar, boiled to perfection.",
        size = "Small",
        grade = 4.7f,
        roastLevel = "Dark",
        ratingsCount = 410
    ),
    Coffee(
        name = "Cold Brew",
        price = 4.00f,
        milk = false,
        milkType = "None",
        description = "A refreshing iced coffee made by steeping coarsely ground beans in cold water for hours.",
        size = "Large",
        grade = 4.6f,
        roastLevel = "Medium",
        ratingsCount = 780
    ),
    Coffee(
        name = "Frappe",
        price = 5.20f,
        milk = true,
        milkType = "Skim",
        description = "A chilled and frothy coffee beverage, blended with milk, ice, and flavorings.",
        size = "Large",
        grade = 4.4f,
        roastLevel = "Light",
        ratingsCount = 490
    )
)
