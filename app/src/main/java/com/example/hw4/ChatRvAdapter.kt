package com.example.hw4

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw4.databinding.SnippetReceiveBinding
import com.example.hw4.databinding.SnippetSendBinding
import java.lang.IllegalArgumentException
import kotlin.random.Random

class ChatRvAdapter(private val list: MutableList<ItemChat> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val msgFromReceiver = arrayOf(
        "Кек",
        "Лол",
        "Бидон",
        "Лупа",
        "Пупа",
        "Привет",
        "Пока",
        "Я твой собеседник и у меня облачко сообщения немного другое!",
        "Ладно",
        "Смотри прикол покажу",
        "Хачите прикол??",
        "Кто прочитал, тот здохнет"
    )

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

    fun addItem(msg: String) {
        list.add(ItemChat(msg, true))
        list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
        list.add(ItemChat(msgFromReceiver[Random.nextInt(msgFromReceiver.size)], false))
        notifyDataSetChanged()
    }
}