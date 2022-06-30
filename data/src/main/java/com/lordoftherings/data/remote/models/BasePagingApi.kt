package com.lordoftherings.data.remote.models

data class BasePagingApi<T>(
    val total: Int,
    val limit : Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val docs: List<T>
)