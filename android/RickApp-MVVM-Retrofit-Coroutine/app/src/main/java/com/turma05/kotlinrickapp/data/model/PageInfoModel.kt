package com.turma05.kotlinrickapp.data.model

import com.google.gson.annotations.SerializedName

data class PageInfoModel (
    @SerializedName("count")
    val total: Int,
    @SerializedName("pages")
    val paginas: Int,
    @SerializedName("next")
    val proximo: String?,
    @SerializedName("prev")
    val anterior: String?
)
