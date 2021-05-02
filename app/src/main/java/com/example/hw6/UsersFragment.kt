package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw6.adapters.AlbumsAdapter
import com.example.hw6.adapters.UsersAdapter
import com.example.hw6.databinding.ActivityNetworkingBinding
import com.example.hw6.databinding.FragmentUsersBinding
import com.example.hw6.network.Repo

class UsersFragment : Fragment() {
    private lateinit var binding: FragmentUsersBinding
    private val repo = Repo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        getUsers()
        return binding.root
    }

    private fun getUsers(){
        repo.getUsers(
            data = {
                binding.usersRV.adapter = UsersAdapter(it ?: listOf())
            },
            error = {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        )
    }
}