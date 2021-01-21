package com.lucas.moviesapp.service

import com.lucas.moviesapp.data.ResultMovie
import retrofit2.http.GET
import retrofit2.http.Query

const val APIKEY = "e8014d38210f3e7f0d80009b43579fa7"
const val POPULAR = "movie/popular"

interface MovieAPI {

    @GET(POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = APIKEY,
        @Query("language") language: String = "pt-BR",
        @Query("page") page: String = "1"
    ): ResultMovie
}