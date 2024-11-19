package com.volkov.notificationjeleapps

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.NotificationManagerCompat
import com.volkov.notification.presentation.NotificationScreen
import com.volkov.notification.presentation.NotificationViewModel
import com.volkov.notificationjeleapps.ui.theme.NotificationJeLeAppsTheme
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotificationJeLeAppsTheme {
                val notificationViewModel: NotificationViewModel = koinViewModel()
                TestNotificationsEnabled()
                NotificationScreen(notificationViewModel)

            }
        }
    }

    // проверим права на уведомления
    fun TestNotificationsEnabled(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                    putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                }
                startActivity(intent)
            }
        }
    }
}