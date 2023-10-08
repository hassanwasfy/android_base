package com.deshanddezz.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("name")
    suspend fun getName(
        @Query("name")
        country: String,
    ): Response<Any>

}