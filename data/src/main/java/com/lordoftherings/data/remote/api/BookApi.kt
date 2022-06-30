package com.lordoftherings.data.remote.api

import com.lordoftherings.data.remote.models.BasePagingApi
import com.lordoftherings.data.remote.models.BookNetwork
import com.lordoftherings.data.remote.models.ChapterNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookApi {
    @GET("/book")
    suspend fun fetchBook(@Query("page") page: Int) : Response<BasePagingApi<BookNetwork>>

    @GET("/book/{id}")
    suspend fun fetchSpecificBook(@Path("id") id : Int) : Response<BasePagingApi<BookNetwork>>

    @GET("/book/{id}/chapter")
    suspend fun fetchBookChapters(@Query("page") page: Int, @Path("id") id : String) : Response<BasePagingApi<ChapterNetwork>>
}