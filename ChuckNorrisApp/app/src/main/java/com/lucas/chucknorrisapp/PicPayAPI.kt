package com.picpay.desafio.android

import com.picpay.desafio.android.model.User
import retrofit2.http.GET

interface PicPayAPI {

    companion object {
        const val SOURCE = "users"
    }

    @GET(SOURCE)
    suspend fun getUsers(): List<User>
}