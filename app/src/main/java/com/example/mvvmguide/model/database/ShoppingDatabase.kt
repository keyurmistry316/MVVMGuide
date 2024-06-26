package com.example.mvvmguide.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.model.dao.ShoppingDao

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
        @Volatile
       private var dbInstance : ShoppingDatabase? = null

         fun getInstance(applicationContext: Context) = synchronized(this) {
            return@synchronized dbInstance ?: Room.databaseBuilder<ShoppingDatabase>(
                applicationContext,
                  ShoppingDatabase::class.java,
                  "shopping_db"
            )
                  .build().also { dbInstance = it }
        }

    }


}