package com.example.mvvmguide.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.mvvmguide.databinding.ActivityShoppingBinding
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.model.database.ShoppingDatabase
import com.example.mvvmguide.repo.ShoppingRepository
import com.example.mvvmguide.utils.AddDialogListener
import com.example.mvvmguide.utils.ShoppingItemClickListener
import com.example.mvvmguide.view.adapters.ShoppingItemAdapter
import com.example.mvvmguide.view.dialogs.ShoppingItemDialog
import com.example.mvvmguide.viewmodel.ShoppingViewModel


class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShoppingBinding
    private lateinit var vm : ShoppingViewModel
    var shoppingList = ArrayList<ShoppingItem>()
    private lateinit var shoppingAdapter : ShoppingItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        vm = ViewModelProvider.create(this)[ShoppingViewModel::class.java]

        val database =  Room.databaseBuilder(applicationContext,
            ShoppingDatabase::class.java,
            "shopping_db").build()

        val repository = ShoppingRepository(database)

        vm.setRepo(repository)


        setContentView(binding.root)
        setAdapter()
        setObservables()

        binding.btnAddItem.setOnClickListener {

                ShoppingItemDialog(this,object :AddDialogListener{
                    override fun addAddItemClick(shoppingItem: ShoppingItem) {
                       vm.upsetItem(item = shoppingItem)
                    }

                }).show()
        }

    }

    private fun setObservables() {

            vm.getShoppingItems().observe(this@ShoppingActivity){
                    shoppingAdapter.setData(it)
            }

    }
    private fun setAdapter() {
         shoppingAdapter = ShoppingItemAdapter(object :ShoppingItemClickListener{
             override fun onClickPlus(shoppingItem: ShoppingItem) {
                 vm.upsetItem(shoppingItem)
             }

             override fun onClickMinus(shoppingItem: ShoppingItem) {
                 vm.upsetItem(shoppingItem)
             }

             override fun onClickDelete(shoppingItem: ShoppingItem) {
                 vm.delete(shoppingItem)
             }

         })
        binding.rv.adapter = shoppingAdapter
        vm.getShoppingItems()
    }
}