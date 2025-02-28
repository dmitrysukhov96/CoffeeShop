package com.dmitrysukhov.coffeeshop

class CoffeeRepository(private val cartDao: CartDao) {

    suspend fun addCoffeeToCart(coffee: Coffee) {
        cartDao.insertCoffee(coffee)
    }

    suspend fun addBeansToCart(beans: Beans) {
        cartDao.insertBeans(beans)
    }
}