package com.example.mvvmguide.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmguide.R
import com.example.mvvmguide.databinding.ShoppingDialogBinding
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.utils.AddDialogListener


class ShoppingItemDialog(context: Context, private val dialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ShoppingDialogBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etItemName.text.toString()
            val amount = binding.etItemAmount.text.toString()

            if(name.isNullOrEmpty() || amount.isNullOrEmpty()){
                Toast.makeText(context,context.getString(R.string.name_and_amount_require),Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val shoppingItem = ShoppingItem(name = name, amount = amount.toInt())
                dialogListener.addAddItemClick(shoppingItem)
                dismiss()
            }
        }
        binding.tvCancel.setOnClickListener { cancel() }
        setCancelable(false)

    }
}