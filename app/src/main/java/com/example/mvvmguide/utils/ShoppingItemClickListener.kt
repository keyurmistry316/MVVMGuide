package com.example.mvvmguide.utils

import com.example.mvvmguide.model.ShoppingItem

interface ShoppingItemClickListener {

    fun onClickPlus(shoppingItem: ShoppingItem)

    fun onClickMinus(shoppingItem: ShoppingItem)

    fun onClickDelete(shoppingItem: ShoppingItem)
}