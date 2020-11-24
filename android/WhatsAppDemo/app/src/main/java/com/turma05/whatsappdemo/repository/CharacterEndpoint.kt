package com.turma05.whatsappdemo.repository

import com.turma05.whatsappdemo.model.CharacterModel
import com.turma05.whatsappdemo.network.NetworkUtils
import retrofit2.http.GET

interface CharacterEndpoint {
    @GET("characters")
    suspend fun obterLista(): List<CharacterModel>

    companion object {
        val Endpoint: CharacterEndpoint by lazy {
            NetworkUtils.getRetrofit().create(CharacterEndpoint::class.java)
        }
    }


}
