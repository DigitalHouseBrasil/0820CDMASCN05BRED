package com.turma05.whatsappdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkUtils {
    companion object {
        fun getRetrofit(baseUrl: String = BASE_URL): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private const val BASE_URL = "https://www.breakingbadapi.com/api/"
    }

}
