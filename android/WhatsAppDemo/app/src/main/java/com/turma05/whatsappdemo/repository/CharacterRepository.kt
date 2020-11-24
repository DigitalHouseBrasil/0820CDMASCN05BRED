package com.turma05.whatsappdemo.repository

class CharacterRepository {

    private val client = CharacterEndpoint.Endpoint

    suspend fun obterLista() = client.obterLista()
}