package com.lucas.moviesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.moviesapp.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher

class MovieViewModelFactory(
    private val ioDispatcher: CoroutineDispatcher,
    private val repository: MovieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            CoroutineDispatcher::class.java,
            MovieRepository::class.java
        ).newInstance(ioDispatcher, repository)
    }
}