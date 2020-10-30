package com.digitalhouse.rickapp.listapersonagem.repository

import android.content.Context
import com.digitalhouse.rickapp.api.RickApi
import com.digitalhouse.rickapp.listapersonagem.model.Personagem

class ListaPersonagemRepository(private val context: Context) {

    fun obterLista(callback: (personagens: List<Personagem>) -> Unit) {
        RickApi.getData(context, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                callback.invoke(personagens)
            }
        })
    }
}