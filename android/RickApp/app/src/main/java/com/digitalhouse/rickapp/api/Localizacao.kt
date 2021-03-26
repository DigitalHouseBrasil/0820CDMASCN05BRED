package com.digitalhouse.rickapp.api

import com.google.gson.annotations.SerializedName

data class Localizacao(
    @SerializedName("name")
    var nome : String
)