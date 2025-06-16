package com.example.useretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
//https://jsonplaceholder.typicode.com/posts
  private  fun getInstance ():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com//")
            .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    fun getApiService() : ApiServices{
        return getInstance().create(ApiServices::class.java)
    }


}