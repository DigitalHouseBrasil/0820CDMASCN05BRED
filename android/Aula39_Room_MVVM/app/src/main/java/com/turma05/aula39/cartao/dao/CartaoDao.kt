package com.turma05.aula39.cartao.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.turma05.aula39.cartao.entity.CartaoEntity

@Dao
interface CartaoDao {

    @Insert
    suspend fun addCartao(cartao: CartaoEntity)

    @Query("SELECT COUNT(*) FROM Cartao")
    suspend fun count(): Int
}