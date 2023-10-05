package com.dezz.data.remote

import com.dezz.data.model.BaseEndPointResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApi {
    @GET("name")
    suspend fun getName(
        @Query("name")  country:String,
    ):Response<BaseEndPointResponse<Any>>
}