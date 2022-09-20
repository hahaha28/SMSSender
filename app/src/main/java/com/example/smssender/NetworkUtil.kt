package com.example.smssender

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit

object NetworkUtil {
    lateinit var okHttpClient: OkHttpClient
    lateinit var webSocket: WebSocket

    fun init(webSocketListener: WebSocketListener) {
        okHttpClient = OkHttpClient.Builder()
            .pingInterval(10, TimeUnit.SECONDS)
            .build()
        val request = Request.Builder()
            .url("127.0.0.1")
            .build()
        webSocket = okHttpClient.newWebSocket(request,webSocketListener)
    }
}