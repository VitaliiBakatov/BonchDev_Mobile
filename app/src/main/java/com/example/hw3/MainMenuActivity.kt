package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw3.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getSerializableExtra("user" ) as User
        val message = intent.getStringExtra("message")
        binding.user.text = user.toString()
        binding.message.text = message
    }
}