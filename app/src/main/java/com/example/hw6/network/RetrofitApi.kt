package com.example.hw6.network

import com.example.hw6.data.Album
import com.example.hw6.data.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {
    @GET("albums")
    suspend fun getAlbums():Response<List<Album>>
    @GET("users")
    suspend fun getUsers():Response<List<User>>
    @POST("posts")
    @FormUrlEncoded
    suspend fun createPost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Int
    ):Response<ResponseBody>
}