package com.example.junioretrofit.domain

import com.example.junioretrofit.data.model.GhibliModel
import com.example.junioretrofit.data.model.GhibliProvider

class GetActorUseCase() {
    operator fun invoke(id:Int): GhibliModel?{
        val actors = GhibliProvider.actors
        if(!actors.isNullOrEmpty()){
            return actors[id]
        }
        return null
    }
}