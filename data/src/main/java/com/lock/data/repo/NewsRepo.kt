package com.dezz.data.repo

import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepo {

        suspend fun getName( apiKey: String,q:String?= null,sortedBy:String?=null):Flow<Response<Any>>


}