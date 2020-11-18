package com.turma05.kotlinrickapp.listagem.repository


class PersonagemRepository {
    private val client = PersonagemEndpoint.endpoint

    suspend fun obterLista(name: String?) = client.obterLista(name)
}
