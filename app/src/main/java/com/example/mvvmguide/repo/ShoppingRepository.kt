package com.example.mvvmguide.repo

import androidx.lifecycle.LiveData
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.model.database.ShoppingDatabase

class ShoppingRepository(
    private val shoppingDatabase: ShoppingDatabase
) {

    suspend fun upsertItem(item:ShoppingItem){
        shoppingDatabase.getShoppingDao().upsert(item)
    }

    suspend fun deleteItem(item:ShoppingItem){
        shoppingDatabase.getShoppingDao().delete(item)
    }

    suspend fun getItems(): LiveData<List<ShoppingItem>> {
        return shoppingDatabase.getShoppingDao().getItems()
    }
}