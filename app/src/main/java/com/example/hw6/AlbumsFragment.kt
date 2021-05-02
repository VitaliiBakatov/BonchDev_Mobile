package com.example.hw6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw6.adapters.AlbumsAdapter
import com.example.hw6.databinding.FragmentAlbumsBinding
import com.example.hw6.databinding.FragmentMenuBinding
import com.example.hw6.network.Repo


class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private val repo = Repo()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        getAlbums()
        return binding.root
    }

    private fun getAlbums(){
        repo.getAlbums(
            data = {
                binding.albumsRV.adapter = AlbumsAdapter(it ?: listOf())
            },
            error = {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        )
    }
}