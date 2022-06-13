package com.example.junioretrofit.database

import androidx.lifecycle.LiveData

class CuidadorRepository(private val cuidadorDao:CuidadorDao) {
    val readAllData: LiveData<List<Cuidador>> = cuidadorDao.readAllData()

    suspend fun add(cuidador:Cuidador){
        cuidadorDao.add(cuidador)
    }
}