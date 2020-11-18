package com.turma05.kotlinrickapp.listagem.model

import com.google.gson.annotations.SerializedName

data class PersonagemModel(
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("image")
    val imagem: String
)