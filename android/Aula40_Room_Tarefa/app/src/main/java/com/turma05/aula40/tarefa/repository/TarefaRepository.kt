package com.turma05.aula40.tarefa.repository

import com.turma05.aula40.tarefa.dao.TarefaDao
import com.turma05.aula40.tarefa.entity.TarefaEntity

class TarefaRepository(private val tarefaDao: TarefaDao) {
    suspend fun inserirTarefa(tarefa: TarefaEntity) = tarefaDao.inserirTarefa(tarefa)
    suspend fun obterTarefas(): List<TarefaEntity> = tarefaDao.obterTarefas()
    suspend fun atualizarTarefa(descricao: String, id: Long) = tarefaDao.atualizarTarefa(descricao, id)
}