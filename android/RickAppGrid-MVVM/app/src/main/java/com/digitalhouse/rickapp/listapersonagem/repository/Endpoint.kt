package com.digitalhouse.rickapp.listapersonagem.repository

import com.digitalhouse.rickapp.listapersonagem.model.Resultado
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.random.Random

interface Endpoint {

    @GET("character")
    fun getPersonagens(@Query("page") page: Int = Random.nextInt(1, 18)) : Call<Resultado>
}
