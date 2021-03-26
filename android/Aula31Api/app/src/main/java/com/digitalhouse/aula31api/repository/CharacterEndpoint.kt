package com.digitalhouse.aula31api.repository

import com.digitalhouse.aula31api.models.ApiResponseModel
import com.digitalhouse.aula31api.models.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterEndpoint {

    @GET("character")
    fun obterPersonagens(): Call<ApiResponseModel<CharacterModel>>

    @GET("character/{id}")
    fun obterDetalhe(@Path("id") id: Int): Call<CharacterModel>
}