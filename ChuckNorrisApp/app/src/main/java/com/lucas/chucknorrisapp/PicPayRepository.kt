package com.picpay.desafio.android

class PicPayRepository {
    suspend fun getUsers() = PicPayService.getApi().getUsers()
}