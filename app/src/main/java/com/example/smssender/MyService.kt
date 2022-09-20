package com.example.smssender

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.smssender.bean.SendSMSCmd
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.util.concurrent.TimeUnit

class MyService : Service() {

    val gson = Gson()

    private val webSocketListener = object : WebSocketListener() {
        override fun onMessage(webSocket: WebSocket, text: String) {
            val cmd = gson.fromJson(text,SendSMSCmd::class.java)
            SMSUtil.send(cmd.tel, cmd.msg)
        }
    }

    override fun onCreate() {
        SMSUtil.init(applicationContext)
        NetworkUtil.init(webSocketListener)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {

        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}