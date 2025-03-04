package com.dmitrysukhov.coffeeshop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoffeeViewModel(private val repository: CoffeeRepository) : ViewModel() {

    var cartItems by mutableStateOf<List<Any>>(emptyList()) // Храним список товаров в корзине
        private set

    init {
        getCartItems() // Загружаем корзину при создании ViewModel
    }

    fun getCartItems() {
        viewModelScope.launch {
            cartItems = repository.getCartItems() // Получаем обновлённые данные из базы
        }
    }

    fun removeFromCart(item: Any) {
        viewModelScope.launch {
            when (item) {
                is Coffee -> repository.removeCoffeeFromCart(item)
                is Beans -> repository.removeBeansFromCart(item)
            }
            getCartItems() // Обновляем UI после удаления
        }
    }
}


