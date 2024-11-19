package com.volkov.notification.di

import com.volkov.notification.data.NotificationRepository
import com.volkov.notification.domain.GetTokenUseCase
import com.volkov.notification.presentation.NotificationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val notificationModule = module{
    // Предоставление контекста приложения для репозитория
    single { NotificationRepository(androidContext()) }
    // Фабрика для создания GetTokenUseCase с зависимостью от NotificationRepository
    factory { GetTokenUseCase(get()) }
    // Создание ViewModel с зависимостью от GetTokenUseCase
    viewModel {
        NotificationViewModel(get())
    }
}