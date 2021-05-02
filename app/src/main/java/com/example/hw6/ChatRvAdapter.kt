package com.example.hw6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.databinding.SnippetReceiveBinding
import com.example.hw6.databinding.SnippetSendBinding
import java.lang.IllegalArgumentException

class ChatRvAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: MutableList<ItemChat> = mutableListOf()

    inner class SendViewHolder(private val binding: SnippetSendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.sendContent.text = list[position].content
        }
    }

    inner class ReceiveViewHolder(private val binding: SnippetReceiveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.receiveContent.text = list[position].content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> SendViewHolder(SnippetSendBinding.inflate(inflater, parent, false))
            0 -> ReceiveViewHolder(SnippetReceiveBinding.inflate(inflater, parent, false))
            else -> throw IllegalArgumentException("No such view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val isFromSender = list[position].isFromSender
        return if (isFromSender) 1 else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SendViewHolder)
            holder.bind(position)
        else if (holder is ReceiveViewHolder)
            holder.bind(position)
    }

    override fun getItemCount() = list.size

    fun updateItems(listItem: List<ItemChat>) {
        list.clear()
        list.addAll(listItem)
        notifyDataSetChanged()
    }
}