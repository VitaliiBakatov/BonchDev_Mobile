package com.example.hw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw4.databinding.ActivityChatBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ChatRvAdapter()
        binding.chatRv.adapter = adapter

        binding.sendMsgIv.setOnClickListener {
            val msg = binding.msgEt.text.toString()
            if (!msg.isEmpty()) {
                adapter.addItem(msg.trim())
                binding.msgEt.setText("")
                binding.chatRv.smoothScrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}