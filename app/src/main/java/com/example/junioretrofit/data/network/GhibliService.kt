package com.example.junioretrofit.data.network

import com.example.junioretrofit.core.RetrofitHelper
import com.example.junioretrofit.data.model.GhibliModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GhibliService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getActors(): List<GhibliModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(GhibliApiClient::class.java).getAllActors()
            response.body() ?: emptyList()
        }
    }
}