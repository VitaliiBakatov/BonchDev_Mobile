package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.hw6.adapters.UsersAdapter
import com.example.hw6.databinding.FragmentCreatePostBinding
import com.example.hw6.databinding.FragmentUsersBinding
import com.example.hw6.network.Repo

class CreatePostFragment : Fragment() {
    private lateinit var binding: FragmentCreatePostBinding
    private val repo = Repo()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePostBinding.inflate(inflater, container, false)
        binding.postBtn.setOnClickListener {
            val title = binding.postTitle.text.toString()
            val body = binding.postBody.text.toString()
            createPost(title, body)
        }
        binding.postTitle.doOnTextChanged { text, start, before, count ->
            binding.postBtn.isEnabled = !text.isNullOrEmpty() && !binding.postBody.text.toString().isEmpty()
        }
        binding.postBody.doOnTextChanged { text, start, before, count ->
            binding.postBtn.isEnabled = !text.isNullOrEmpty() && !binding.postTitle.text.toString().isEmpty()
        }
        return binding.root
    }

    private fun createPost(title:String, body: String){
        repo.createPost(title, body, 1,
            success = {
                Toast.makeText(context, "Пост создан успешно!!!", Toast.LENGTH_LONG).show()
            },
            error = {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        )
    }
}