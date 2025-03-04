package com.dmitrysukhov.coffeeshop

class CoffeeRepository(private val cartDao: CartDao) {

    suspend fun addCoffeeToCart(coffee: Coffee) {
        cartDao.insertCoffee(coffee)
    }

    suspend fun addBeansToCart(beans: Beans) {
        cartDao.insertBeans(beans)
    }

    suspend fun removeCoffeeFromCart(coffee: Coffee) {
        cartDao.deleteCoffee(coffee)
    }

    suspend fun removeBeansFromCart(beans: Beans) {
        cartDao.deleteBeans(beans)
    }

    suspend fun getCartItems(): List<Any> {
        return cartDao.getAllCartItems()
    }
}
