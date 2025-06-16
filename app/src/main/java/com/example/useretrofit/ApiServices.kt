package com.example.useretrofit

import com.example.useretrofit.models.PostResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("posts")
//https://jsonplaceholder.typicode.com/c
suspend fun getPosts():List<PostResponseItem>




}