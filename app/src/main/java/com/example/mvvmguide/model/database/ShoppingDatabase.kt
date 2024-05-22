package com.example.mvvmguide.model.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.model.dao.ShoppingDao

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

}