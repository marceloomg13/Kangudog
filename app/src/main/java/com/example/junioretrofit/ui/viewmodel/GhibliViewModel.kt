package com.example.junioretrofit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.junioretrofit.data.model.GhibliModel
import com.example.junioretrofit.data.model.GhibliProvider
import com.example.junioretrofit.domain.GetActorsUseCase
import com.example.junioretrofit.domain.GetActorUseCase
import kotlinx.coroutines.launch

class GhibliViewModel : ViewModel() {
    val GhibliModel = MutableLiveData<GhibliModel>()
    var getActorsUseCase = GetActorsUseCase()

    val isLoading = MutableLiveData<Boolean>()
    var getRandomActorUseCase = GetActorUseCase()

    fun randomGhibli(id:Int) {
        isLoading.postValue(true)
        val actor = getRandomActorUseCase(id)
        println(actor)
        if(actor!=null){
            GhibliModel.postValue(actor)
        }
        isLoading.postValue(false)
    }

    fun onCreate(id: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getActorsUseCase()
            if(!result.isNullOrEmpty()){
                GhibliModel.postValue(result[0])
                isLoading.postValue(false)
                randomGhibli(id)
            }
        }
    }
}