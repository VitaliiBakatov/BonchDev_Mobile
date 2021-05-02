package com.example.hw6.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.data.Album
import com.example.hw6.databinding.ItemBinding

class AlbumsAdapter(private val list: List<Album>): RecyclerView.Adapter<AlbumsAdapter.Holder>() {
    inner class Holder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.first.text = "UserId: " + list[position].userId.toString()
            binding.second.text = "Id: " + list[position].id.toString()
            binding.third.text = "Title: " + list[position].title.toString()
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