package com.example.junioretrofit.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.junioretrofit.database.Cuidador
import com.example.junioretrofit.database.CuidadorDatabase
import com.example.junioretrofit.database.CuidadorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Fragmento3ViewModel(aplication:Application):AndroidViewModel(aplication) {

    private val readAllData: LiveData<List<Cuidador>>
    private val repository:CuidadorRepository

    init{
        val cuidadorDao = CuidadorDatabase.getDatabase(aplication).cuidadorDao()
        repository = CuidadorRepository(cuidadorDao)
        readAllData = repository.readAllData
    }
    fun add(cuidador:Cuidador){
        viewModelScope.launch(Dispatchers.IO){
            repository.add(cuidador)
        }
    }
}