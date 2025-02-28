package com.dmitrysukhov.coffeeshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoffeeViewModel(private val repository: ) : ViewModel() {
    fun addToCart() {
        viewModelScope.launch {
            selectedItem?.let { item ->
                when (item) {
                    is Coffee -> repository.addCoffeeToCart(item)
                    is Beans -> repository.addBeansToCart(item)
                }
            }
        }
    }


    var selectedItem: Any? = null
}