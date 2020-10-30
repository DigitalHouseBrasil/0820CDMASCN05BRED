package com.digitalhouse.rickapp.listapersonagem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.digitalhouse.rickapp.listapersonagem.model.Personagem
import com.digitalhouse.rickapp.listapersonagem.repository.ListaPersonagemRepository

class ListaPersonagemViewModel(
    private val repository: ListaPersonagemRepository
): ViewModel() {

    val personagens = MutableLiveData<List<Personagem>>()

    fun obterLista() {
        repository.obterLista { lista ->
            personagens.value = lista
        }
    }

    class ListaPersonagemViewModelFactory(
        private val repository: ListaPersonagemRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListaPersonagemViewModel(repository) as T
        }
    }
}