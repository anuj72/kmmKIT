package com.maddeveloper.kmmkit.repo

import com.maddeveloper.kmmkit.model.ErrorResponse
import com.maddeveloper.kmmkit.model.Resource
import com.maddeveloper.kmmkit.service.AppService
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo {
    suspend fun getDog(count:Int) = withContext(Dispatchers.Default) {
        try {
            val response = AppService().getDog(count)
            Resource.Success(response.message)
        } catch (requestException: ResponseException) {
            try {
                Resource.Error(
                    error = requestException.response.body<ErrorResponse>().message,
                    statusCode = requestException.response.status.value
                )
            } catch (e: Exception) {
                Resource.Error(error = requestException.message ?: "Something went wrong")
            }
        } catch (e: Exception) {
            Resource.Error(error = e.message ?: "")
        }
    }
}