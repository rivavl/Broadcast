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
                Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

/*
* BroadcastReceiver нужен, чтобы реагировать на широковещательные сообщения
* (сообщения, которые отправляет система при наступлении определенных событий)
*
* Нужно зарегестрировать и отписаться, чтобы небыло утечек памяти
* */