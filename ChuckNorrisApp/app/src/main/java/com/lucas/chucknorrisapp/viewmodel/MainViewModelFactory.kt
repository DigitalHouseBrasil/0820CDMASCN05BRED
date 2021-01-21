package com.picpay.desafio.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.PicPayRepository
import kotlinx.coroutines.CoroutineDispatcher

class MainViewModelFactory(
    private val ioDispatcher: CoroutineDispatcher,
    private val repository: PicPayRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            CoroutineDispatcher::class.java,
            PicPayRepository::class.java
        ).newInstance(ioDispatcher, repository)
    }
}