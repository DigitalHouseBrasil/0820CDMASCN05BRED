package com.turma05.aula40.tarefa.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tarefa")
data class TarefaEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo
    var descricao: String
)