package com.turma05.aula40.tarefa.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.turma05.aula40.tarefa.entity.TarefaEntity
import com.turma05.aula40.tarefa.repository.TarefaRepository
import kotlinx.coroutines.Dispatchers

class TarefaViewModel(private val repository: TarefaRepository): ViewModel() {

    fun inserirTarefa(descricao: String) = liveData(Dispatchers.IO) {
        val tarefa = TarefaEntity(0, descricao)
        val newId = repository.inserirTarefa(TarefaEntity(0, descricao))

        tarefa.id = newId

        emit(tarefa)
    }

    fun obterTarefas() = liveData(Dispatchers.IO) {
        emit(repository.obterTarefas())
    }

    fun atualizarTarefa(id: Long, descricao: String) = liveData(Dispatchers.IO) {
        repository.atualizarTarefa(descricao, id)
        emit(true)
    }

    class TarefaViewModelFactory(private val repository: TarefaRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TarefaViewModel(repository) as T
        }

    }
}