package com.maddeveloper.kmmkit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogRes(
    @SerialName("message")
    val message: List<String> = emptyList(),
    @SerialName("status")
    val status: String?=null,
    @SerialName("error")
    val error: String?=null
)