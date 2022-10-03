package com.maddeveloper.kmmkit.repo

import com.maddeveloper.kmmkit.model.ErrorResponse
import com.maddeveloper.kmmkit.model.Resource
import com.maddeveloper.kmmkit.service.AppService
import com.maddeveloper.kmmkit.wrapper.UiState
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class AppRepo {

    @Throws(Exception::class)
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



    @Throws(Exception::class)
    suspend fun getDataFlow(count:Int) = withContext(Dispatchers.Default) {
        val uiState = MutableSharedFlow<UiState<List<String>>>()
        uiState.tryEmit(UiState.Loading)
        try {
            val response = AppService().getDog(count)
            uiState.tryEmit(UiState.Success(response.message))
        } catch (requestException: ResponseException) {
            uiState.tryEmit(UiState.Error(requestException))
        } catch (e: Exception) {
            uiState.tryEmit(UiState.Error(e))
        }

    }

   /* private suspend fun fetchPokemonList(offset: Int, limit: Int) =
        flow {
            emit(Loading())
            val result = pokemonApi.get(offset, limit)
            if (result is Success) {
                if (offset == 0) {
                    pokemonDao.deleteAll()
                }
                pokemonDao.insert(result.data.results.map { it.toDaoModel() })
            }
            emit(result.map { PaginatedList(it.results.map { it.toDomainModel() }, it.count) })
        }*/



}