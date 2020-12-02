package com.turma05.aula39.cartao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cartao")
data class CartaoEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var numero: String,
    @ColumnInfo
    var titular: String,
    @ColumnInfo
    var cvv: String,
    @ColumnInfo
    var validade: String,
    @ColumnInfo
    var bandeira: String
)