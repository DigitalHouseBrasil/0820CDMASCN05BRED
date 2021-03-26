package com.lucas.whatsapp.repository

class CharacterRepository {
    private val client = CharacterEndpoint.endpoint

    suspend fun obterLista() =  client.obterLista()
}