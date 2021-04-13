package com.example.hw5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hw5.databinding.ActivityChatBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ChatRvAdapter()
        binding.chatRv.adapter = adapter

        val model: ChatViewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        model.data.observe(this, Observer {
            adapter.updateItems(it)
            binding.chatRv.smoothScrollToPosition(adapter.itemCount - 1)
        })

        binding.sendMsgIv.setOnClickListener {
            val msg = binding.msgEt.text.toString()
            if (!msg.isEmpty()) {
                model.updateMessageList(msg)
                binding.msgEt.setText("")
            }
        }
    }
}