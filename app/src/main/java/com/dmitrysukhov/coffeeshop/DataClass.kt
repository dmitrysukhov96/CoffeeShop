package com.dmitrysukhov.coffeeshop

data class Coffee(
    var name: String,
    var price: Float,
    var milk: Boolean,
    var milkType: String,
    var description:String,
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
    var grade: Float
)