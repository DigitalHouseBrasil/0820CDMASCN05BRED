package com.lucas.moviesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.moviesapp.repository.MovieRepository
import com.lucas.moviesapp.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(
    private val ioDispatcher: CoroutineDispatcher,
    private val repository: MovieRepository
) : ViewModel() {
    var stateList: MutableLiveData<List<Result>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListUsers() {
        viewModelScope.launch {
            loading.value = true
            try {
                val usersResult = withContext(ioDispatcher) {
                    repository.getUsers().results
                }
                stateList.value = usersResult
                loading.value = false
            } catch (ex: Exception) {
                errorMessage("It looks like we had a problem. Try later!")
            } finally {
                loading.value = false
            }
        }
    }

    private fun errorMessage(message: String) {
        error.value = message
    }
}