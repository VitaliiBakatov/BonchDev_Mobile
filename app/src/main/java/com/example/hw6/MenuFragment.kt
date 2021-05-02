package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hw6.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        setListeners()
        return binding.root
    }

    private fun setListeners(){
        val controller = requireActivity().findNavController(R.id.fragment_container)
        binding.albums.setOnClickListener {
            controller.navigate(R.id.albumsFragment)
        }
        binding.users.setOnClickListener {
            controller.navigate(R.id.usersFragment)
        }
        binding.createPost.setOnClickListener {
            controller.navigate(R.id.createPostFragment)
        }
    }

}