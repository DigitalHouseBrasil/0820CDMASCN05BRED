package com.turma05.kotlinrickapp.data.model

import androidx.annotation.Keep

@Keep
data class ResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)