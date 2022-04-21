package com.marina.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    // в этот метод прилетают все сообщения
    // context - activity, которая зарегестрировала ресивер
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "Airplane mode changed. Turned on: $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "Low Battery", Toast.LENGTH_SHORT).show()
            }
            ACTION_CLICKED -> {
                val counter = intent.getIntExtra(EXTRA_COUNT, 0)
                Toast.makeText(context, "Clicked $counter times", Toast.LENGTH_SHORT).show()
            }
            "loaded" -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "Loaded $percent", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "clicked"
        const val EXTRA_COUNT = "count"
    }
}

/*
* BroadcastReceiver нужен, чтобы реагировать на широковещательные сообщения
* (сообщения, которые отправляет система при наступлении определенных событий)
*
* Нужно зарегестрировать и отписаться, чтобы небыло утечек памяти
* */