package com.lordoftherings.data.remote.api

import com.lordoftherings.data.remote.models.BasePagingApi
import com.lordoftherings.data.remote.models.CharacterDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("/character")
    suspend fun fetchCharacters(@Query("page") page : Int) : Response<BasePagingApi<CharacterDto>>

    @GET("/character/{id}")
    suspend fun fetchSpecificCharacter(@Path("id") id : Int) : Response<BasePagingApi<CharacterDto>>
}