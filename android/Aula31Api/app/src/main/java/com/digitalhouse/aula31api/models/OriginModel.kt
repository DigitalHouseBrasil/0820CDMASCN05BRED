package com.digitalhouse.aula31api.models

import com.google.gson.annotations.SerializedName

data class OriginModel (
    @SerializedName("name")
    val nome: String,
    val url: String
)