package com.example.mvvmguide.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.repo.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository
):ViewModel() {

    fun upsetItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        shoppingRepository.upsertItem(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch{
        shoppingRepository.deleteItem(item)
    }

    fun getShoppingItems() = CoroutineScope(Dispatchers.IO).launch {
        shoppingRepository.getItems()
    }

}