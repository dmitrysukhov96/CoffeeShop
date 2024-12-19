package com.dmitrysukhov.coffeeshop

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
