package com.volkov.notification.domain

import com.volkov.notification.data.NotificationRepository
import kotlinx.coroutines.flow.Flow

class GetTokenUseCase(private val repository: NotificationRepository) {
    operator fun invoke(): Flow<String> = repository.getToken()
}