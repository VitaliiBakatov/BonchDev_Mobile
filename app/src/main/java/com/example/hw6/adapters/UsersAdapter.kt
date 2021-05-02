package com.example.hw6.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.data.User
import com.example.hw6.databinding.ItemBinding

class UsersAdapter(private val list: List<User>): RecyclerView.Adapter<UsersAdapter.Holder>() {
    inner class Holder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val first = list[position].name + ", " + list[position].username
            val third = list[position].address.street + ", " + list[position].address.suite + ", " + list[position].address.city
            binding.first.text = first
            binding.second.text = list[position].email
            binding.third.text = third
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(position)

    override fun getItemCount(): Int = list.size

}