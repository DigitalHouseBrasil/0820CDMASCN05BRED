package com.digitalhouse.rickapp.listapersonagem.repository

import com.digitalhouse.rickapp.listapersonagem.model.Personagem

interface IRespostaDaApi {
    fun obtevePersonagens(personagens: List<Personagem>)
}