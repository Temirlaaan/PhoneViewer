package com.example.phoneviewer.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createApplicationService(baseUrl: String): ApiServices {
    val gson = GsonBuilder().create()
    val headerInterceptor = HeaderInterceptor()
    val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(headerInterceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
    return retrofit.create(ApiServices::class.java)
}