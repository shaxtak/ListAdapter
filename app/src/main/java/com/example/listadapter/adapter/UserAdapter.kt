package com.example.listadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listadapter.databinding.ItemRvBinding
import com.example.listadapter.models.User

class UserAdapter : ListAdapter<User, UserAdapter.Vh>(MyDiffUtils()){

    lateinit var itemClick: ((User) -> Unit)

    inner class Vh(private val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(user: User){
            itemRvBinding.text1.text = user.name
            itemRvBinding.text2.text = user.views
            itemRvBinding.text3.text = user.date
            itemRvBinding.imageView.imageAlpha = user.imageView
            itemRvBinding.root.setOnClickListener {
                itemClick(user)
            }
        }
    }

    class MyDiffUtils : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}