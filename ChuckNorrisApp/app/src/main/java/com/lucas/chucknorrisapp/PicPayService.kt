package com.picpay.desafio.android

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PicPayService {
    companion object {
        var BASE_URL = "http://careers.picpay.com/tests/mobdev/"
        private val gson = GsonBuilder().setLenient().create()
        private val httpClient = OkHttpClient.Builder()

        init {
            val httpClient = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(logging)
            }
        }

        fun getApi(): PicPayAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()
                .create(PicPayAPI::class.java)
        }

        fun setBaseUrl(baseUrl: String) {
            BASE_URL = baseUrl
        }
    }
}