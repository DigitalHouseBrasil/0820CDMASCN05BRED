package com.digitalhouse.rickapp.listapersonagem.model

import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("name")
    var nome : String
)