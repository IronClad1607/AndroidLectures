package com.example.networkfetch.network

import com.example.networkfetch.modal.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi{

    @GET("/users")
    suspend fun getUsers():Response<List<User>>
}