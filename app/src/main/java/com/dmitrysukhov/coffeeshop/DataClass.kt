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








data class Drink(
    val name: String,
    val description: String,
    val price: Double,
    val size: String,
    val caffeineContent: Int, // in mg
    val isHot: Boolean
)

val drinks = listOf(
    Drink(name = "Cappuccino", description = "Espresso with steamed milk and foam", price = 3.50, size = "Medium", caffeineContent = 150, isHot = true),
    Drink(name = "Latte", description = "Espresso with a lot of steamed milk and a little foam", price = 4.00, size = "Large", caffeineContent = 120, isHot = true),
    Drink(name = "Doppio", description = "A double shot of espresso", price = 2.75, size = "Small", caffeineContent = 150, isHot = true),
    Drink(name = "Mocha", description = "Espresso mixed with chocolate and steamed milk", price = 4.50, size = "Large", caffeineContent = 140, isHot = true),
    Drink(name = "Americano", description = "Espresso with hot water", price = 2.50, size = "Medium", caffeineContent = 100, isHot = true),
    Drink(name = "Espresso", description = "Strong black coffee", price = 2.00, size = "Small", caffeineContent = 80, isHot = true),
    Drink(name = "Macchiato", description = "Espresso topped with a small amount of foam", price = 3.00, size = "Small", caffeineContent = 120, isHot = true),
    Drink(name = "Flat White", description = "Steamed milk poured over a shot of espresso", price = 3.75, size = "Medium", caffeineContent = 130, isHot = true),
    Drink(name = "Iced Coffee", description = "Chilled brewed coffee served over ice", price = 3.00, size = "Large", caffeineContent = 90, isHot = false),
    Drink(name = "Cold Brew", description = "Coffee brewed slowly with cold water", price = 3.50, size = "Large", caffeineContent = 120, isHot = false),
    Drink(name = "Frappuccino", description = "Blended iced coffee drink with whipped cream", price = 4.75, size = "Large", caffeineContent = 110, isHot = false),
    Drink(name = "Chai Latte", description = "Spiced tea mixed with steamed milk", price = 3.50, size = "Medium", caffeineContent = 50, isHot = true),
    Drink(name = "Matcha Latte", description = "Green tea powder mixed with steamed milk", price = 4.00, size = "Large", caffeineContent = 30, isHot = true),
    Drink(name = "Hot Chocolate", description = "Steamed milk mixed with chocolate syrup", price = 3.25, size = "Medium", caffeineContent = 10, isHot = true),
    Drink(name = "Nitro Cold Brew", description = "Cold brew infused with nitrogen for a creamy texture", price = 4.25, size = "Large", caffeineContent = 125, isHot = false)
)

