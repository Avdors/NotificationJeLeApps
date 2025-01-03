package com.volkov.notification.data

import android.content.Context
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class NotificationRepository(private val context: Context) {
    fun getToken(): Flow<String> = flow {
    emit(FirebaseMessaging.getInstance().token.await())
}

    fun getSavedToken(): Flow<String> = flow {
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("firebaseToken", "Token is unavailable")
        emit(token ?: "Token is unavailable")
    }

}