package com.example.smssender

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionX.init(this)
            .permissions(Manifest.permission.SEND_SMS)
            .request { allGranted, grantedList, deniedList ->

            }
        SMSUtil.init(this)

        findViewById<Button>(R.id.button).setOnClickListener {
            SMSUtil.send("18742024336","test")
        }
    }
}