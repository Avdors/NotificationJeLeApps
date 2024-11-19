package com.volkov.notification.data

import android.content.Intent
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.volkov.notification.R

const val CHANNEL_lID = "channel1"

class FirebaseNotificationService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Здесь вы можете отправить токен на сервер или сохранить его в SharedPreferences
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        message.data.isNotEmpty().let {
            // Здесь можно обработать данные, например, отправить их в LiveData или через EventBus
            if (NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                showNotification(message.data["title"], message.data["body"])
            } else {
                // Перенаправление пользователя на настройки уведомлений
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }

    fun showNotification(title: String?, body: String?) {
        val notificationId = System.currentTimeMillis().toInt()  // Уникальный ID для уведомления
        val builder = NotificationCompat.Builder(this, CHANNEL_lID)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }
}