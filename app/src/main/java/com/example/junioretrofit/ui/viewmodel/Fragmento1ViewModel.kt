package com.example.junioretrofit.ui.viewmodel

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.junioretrofit.R

class Fragmento1ViewModel:ViewModel() {

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String>
        get() = _nombre

    private val _fecha = MutableLiveData<String>()
    val fecha: LiveData<String>
        get() = _fecha

}