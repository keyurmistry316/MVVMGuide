package com.example.mvvmguide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.repo.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShoppingViewModel(
):ViewModel() {

    private lateinit var shoppingRepository: ShoppingRepository

    fun setRepo(repository: ShoppingRepository) {
        this.shoppingRepository = repository
    }

    fun upsetItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        shoppingRepository.upsertItem(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch{
        shoppingRepository.deleteItem(item)
    }

    fun getShoppingItems() = shoppingRepository.getItems()


}