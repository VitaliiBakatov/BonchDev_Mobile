package com.example.hw6.network

import com.example.hw6.data.Album
import com.example.hw6.data.User
import kotlinx.coroutines.*

typealias DataHandler<T> = (data: T?) -> Unit
typealias SuccessHandler = () -> Unit
typealias ErrorHandler = (error: String) -> Unit

class Repo {
    val service = Retrofit.getRetrofit().create(RetrofitApi::class.java)

    fun getAlbums(data: DataHandler<List<Album>>, error: ErrorHandler) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getAlbums()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful)
                        data(response.body())
                    else
                        error(response.code().toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    error(e.message.toString())
                }
            }
        }
    }

    fun getUsers(data: DataHandler<List<User>>, error: ErrorHandler) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getUsers()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful)
                        data(response.body())
                    else
                        error(response.code().toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    error(e.message.toString())
                }
            }
        }
    }

    fun createPost(title: String, body: String, userId: Int, success: SuccessHandler, error: ErrorHandler) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.createPost(title, body, userId)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful)
                        success()
                    else
                        error(response.code().toString())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    error(e.message.toString())
                }
            }
        }
    }
}