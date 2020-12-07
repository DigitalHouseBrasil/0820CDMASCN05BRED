package com.turma05.aula40.tarefa.dao

import androidx.room.*
import com.turma05.aula40.tarefa.entity.TarefaEntity

@Dao
interface TarefaDao {
    @Insert
    suspend fun inserirTarefa(tarefa: TarefaEntity): Long

    @Query("SELECT * FROM Tarefa")
    suspend fun obterTarefas(): List<TarefaEntity>

    @Transaction
    @Query("UPDATE Tarefa SET descricao = :descricao Where id = :id")
    fun atualizarTarefa(descricao: String, id: Long)

    @Update @Transaction
    fun atualizarTarefa(tarefa: TarefaEntity)
}