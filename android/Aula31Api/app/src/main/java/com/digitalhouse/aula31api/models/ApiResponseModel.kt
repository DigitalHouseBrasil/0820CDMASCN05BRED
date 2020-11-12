package com.digitalhouse.aula31api.models

data class ApiResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)