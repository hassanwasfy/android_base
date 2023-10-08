package com.dezz.data.repo

import com.dezz.data.remote.UserApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val api: UserApi):NewsRepo {
    override suspend fun getName(
        apiKey: String,
        q: String?,
        sortedBy: String?
    ): Flow<Response<Any>> {
        TODO("Not yet implemented")
    }


}