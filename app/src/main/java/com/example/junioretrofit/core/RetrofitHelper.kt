package com.example.junioretrofit.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}