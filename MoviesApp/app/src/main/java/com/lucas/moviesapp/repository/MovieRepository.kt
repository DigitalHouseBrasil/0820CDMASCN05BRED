package com.lucas.moviesapp.repository

import com.lucas.moviesapp.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository {
    suspend fun getUsers() =
        withContext(Dispatchers.IO) {
            MovieService.getApi().getPopularMovies()
        }
}