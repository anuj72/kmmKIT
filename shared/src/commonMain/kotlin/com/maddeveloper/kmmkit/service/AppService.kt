package com.maddeveloper.kmmkit.service

import com.maddeveloper.kmmkit.BaseUrl
import com.maddeveloper.kmmkit.Ktor
import com.maddeveloper.kmmkit.model.DogRes
import io.github.aakira.napier.Napier
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class AppService {
    private val httpClient = Ktor.Client.httpClient
    suspend fun getDog(count:Int): DogRes {
        Napier.v(count.toString())
        val url = BaseUrl.plus("/breed/hound/images/random/${count}")
        val response: HttpResponse = httpClient.get(url) {
          /*  parameter("p1", "mCode")
            parameter("page", "page")*/
        }
        return response.body()
    }
}