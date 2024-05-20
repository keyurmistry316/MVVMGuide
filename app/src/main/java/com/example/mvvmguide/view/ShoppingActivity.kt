package com.example.mvvmguide.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmguide.databinding.ActivityShoppingBinding
import com.example.mvvmguide.viewmodel.ShoppingViewModel

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShoppingBinding
    val vm by lazy { ViewModelProvider(this)[ShoppingViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}