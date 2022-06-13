package com.example.junioretrofit.data.network

import com.example.junioretrofit.data.model.GhibliModel
import retrofit2.Response
import retrofit2.http.GET

interface GhibliApiClient {
    @GET("/people")
    suspend fun getAllActors(): Response<List<GhibliModel>>
}
