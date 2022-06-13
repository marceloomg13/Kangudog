package com.example.junioretrofit.domain

import com.example.junioretrofit.data.GhibliRepository
import com.example.junioretrofit.data.model.GhibliModel

class GetActorsUseCase {
    private val repository = GhibliRepository()
    suspend operator fun invoke():List<GhibliModel>? = repository.getAllActors()

}