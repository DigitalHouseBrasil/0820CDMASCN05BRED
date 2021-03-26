package com.lucas.whatsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.lucas.whatsapp.model.CharacterModel
import com.lucas.whatsapp.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel (private val repository: CharacterRepository): ViewModel() {

    private var _characters: List<CharacterModel> = listOf()

    fun obterLista() = liveData(Dispatchers.IO) {
        // Obtem dados da API
        val response = repository.obterLista()

        _characters = response

        emit(response)
    }

    class PersonagemViewModelFactory(
        private val repository: CharacterRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}