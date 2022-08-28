package com.maddeveloper.kmmkit

import kotlin.coroutines.CoroutineContext

expect class Platform() {
    val platform: String
}

expect fun initLogger()

