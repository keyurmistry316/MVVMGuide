package com.example.mvvmguide.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmguide.databinding.ActivityShoppingBinding
import com.example.mvvmguide.model.database.ShoppingDatabase
import com.example.mvvmguide.repo.ShoppingRepository
import com.example.mvvmguide.viewmodel.ShoppingViewModel

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm  by lazy { ViewModelProvider.create(this, factory = object :ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ShoppingViewModel(shoppingRepository = ShoppingRepository(ShoppingDatabase.getInstance(applicationContext))) as T
            }
        })}


    }
}