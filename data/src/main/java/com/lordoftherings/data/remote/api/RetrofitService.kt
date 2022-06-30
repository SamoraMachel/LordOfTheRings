package com.lordoftherings.data.remote.api

import com.lordoftherings.shared.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okhttp = OkHttpClient.Builder()
        .addInterceptor(logger)
        .addInterceptor( Interceptor { chain ->
            var request = chain.request()
            val requestBuilder = request.newBuilder()

            // add token authentication
            requestBuilder.header("Authorization", Constants.AUTH_TOKEN)

            chain.proceed(requestBuilder.build())
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.WEBSITE_URL)
        .client(okhttp)
        .build()

    fun <T> buildService(serviceType : Class<T>) : T {
        return retrofit.create(serviceType)
    }
}