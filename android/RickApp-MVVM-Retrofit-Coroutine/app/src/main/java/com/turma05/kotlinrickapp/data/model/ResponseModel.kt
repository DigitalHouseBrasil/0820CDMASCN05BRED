package com.turma05.kotlinrickapp.data.model

data class ResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)