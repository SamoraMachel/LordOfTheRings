package com.lordoftherings.data.remote.api

import com.lordoftherings.data.remote.models.BasePagingApi
import com.lordoftherings.data.remote.models.MovieDto
import com.lordoftherings.data.remote.models.QuoteDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie")
    suspend fun fetchMovies(@Query("page") page : Int) : Response<BasePagingApi<MovieDto>>

    @GET("/movie/{id}")
    suspend fun fetchSpecificMovie(@Path("id") id : Int) : Response<BasePagingApi<MovieDto>>

    @GET("/movie/{id}/quote")
    suspend fun fetchQuotes(@Query("page") page : Int) : Response<BasePagingApi<QuoteDto>>
}