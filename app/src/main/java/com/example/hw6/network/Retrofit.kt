package com.example.hw6.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofit {
    fun getRetrofit():Retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl("http://jsonplaceholder.typicode.com/").build()
}