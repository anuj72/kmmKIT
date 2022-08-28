package com.maddeveloper.kmmkit.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ErrorResponse(
    val message: String = "Something went wrong",
    val error: Boolean = false,
    //val errorDetails: String = "Something went wrong",
    // Default 0.
    // 100 is client request exception
    @Transient
    var statusCode: Int = 0
)