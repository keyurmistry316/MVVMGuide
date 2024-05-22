package com.example.mvvmguide.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmguide.databinding.ShoppingItemBinding
import com.example.mvvmguide.model.ShoppingItem
import com.example.mvvmguide.utils.ShoppingItemClickListener

class ShoppingItemAdapter(val shoppingItemClickListener: ShoppingItemClickListener) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>()
{
        private var items = ArrayList<ShoppingItem>()

    inner class ShoppingViewHolder(private val binding:ShoppingItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(shoppingItem: ShoppingItem) {

            binding.tvName.text= shoppingItem.name
            binding.tvAmount.text = shoppingItem.amount.toDouble().toString()

            binding.ivDelete.setOnClickListener {
                shoppingItemClickListener.onClickDelete(shoppingItem)
            }
            binding.ivPlus.setOnClickListener {
                shoppingItem.amount++
                shoppingItemClickListener.onClickPlus(shoppingItem)
            }
            binding.ivMinus.setOnClickListener {
                if(shoppingItem.amount>0){
                    shoppingItem.amount--
                    shoppingItemClickListener.onClickMinus(shoppingItem)
                 }

            }

        }

    }

    fun setData(shoppingItems: List<ShoppingItem>){
        items.clear()
        this.items = ArrayList(shoppingItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {

        val view = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
            holder.bind(items[position])
    }
}