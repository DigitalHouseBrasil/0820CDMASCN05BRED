package com.lucas.whatsapp.repository

import com.lucas.whatsapp.model.CharacterModel
import com.lucas.whatsapp.network.NetworkUtils
import retrofit2.http.GET

interface CharacterEndpoint {
    @GET("characters")
    suspend fun obterLista(): MutableList<CharacterModel>

    companion object {
        val endpoint: CharacterEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CharacterEndpoint::class.java)
        }
    }
}