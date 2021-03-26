package com.digitalhouse.aula28.contador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {

    var contador = MutableLiveData<Int>().apply { value = Int.MAX_VALUE }

    fun incrementar() {
        contador.value = contador.value!! + 1
    }
}

// Grupo 7