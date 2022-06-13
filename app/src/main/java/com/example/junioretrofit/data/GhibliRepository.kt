package com.example.junioretrofit.data

import com.example.junioretrofit.data.model.GhibliModel
import com.example.junioretrofit.data.model.GhibliProvider
import com.example.junioretrofit.data.network.GhibliService

class GhibliRepository {
    private val api = GhibliService()
    suspend fun getAllActors():List<GhibliModel>{
        val response = api.getActors()
        GhibliProvider.actors= response
        return response
    }
}