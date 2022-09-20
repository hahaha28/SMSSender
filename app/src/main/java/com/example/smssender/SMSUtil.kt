package com.example.smssender

import android.content.Context
import android.os.Build
import android.telephony.SmsManager
import android.telephony.SubscriptionManager
import android.util.Log

object SMSUtil {

    private lateinit var smsManager: SmsManager

    fun init(context: Context) {
        smsManager = SmsManager.getDefault()
    }

    fun send(tel: String, msg: String) {
        smsManager.sendTextMessage(tel, null, msg, null, null)
    }

}