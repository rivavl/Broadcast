package com.marina.broadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val receiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        // если регистрируем в onCreate, то unregisterReceiver в onDestroy
        // если регистрируем в onStart, то unregisterReceiver в onStop
        unregisterReceiver(receiver)
    }
}