package com.turma05.kotlinrickapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {
    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getRetrofitInstance(baseUrl: String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}