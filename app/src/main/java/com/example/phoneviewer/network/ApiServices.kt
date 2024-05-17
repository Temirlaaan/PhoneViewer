package com.example.phoneviewer.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("catalog")
    suspend fun getMainMovies(
        @Query("page") page: Int = 1,
        @Query("page_limit") pageLimit: Int = 24, // Adjust pageLimit as needed
        @Query("section") section: String = "smartfony"
    ): retrofit2.Response<MainDTO>

}