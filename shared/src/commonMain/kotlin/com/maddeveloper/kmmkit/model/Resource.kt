package com.maddeveloper.kmmkit.model

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(
        val data: T? = null,
        var error: String,
        val statusCode: Int = 100
    ) : Resource<T>() {
        init {
            if (error.contains("UnknownHostException", true)) {
                error = "Check your internet connection"
            }
        }
    }
    data class Loading<T>(val data: T? = null) : Resource<T>()


    fun peekIsLoading()= this is Loading

    fun peekData() = if (this is Success) this.data else null

    fun peekError() = if (this is Error) this.error else null

    fun peekStatusCode() = if (this is Error) this.statusCode else null




}