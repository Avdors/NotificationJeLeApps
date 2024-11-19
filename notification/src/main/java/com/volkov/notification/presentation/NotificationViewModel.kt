package com.volkov.notification.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volkov.notification.domain.GetTokenUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class NotificationViewModel(private val getTokenUseCase: GetTokenUseCase) : ViewModel() {
    private val _token = MutableStateFlow("")
    val token: StateFlow<String> = _token.asStateFlow()

    init {
        loadToken()
        loadSavedToken()
    }

    private fun loadToken() {
        viewModelScope.launch {
            getTokenUseCase().collect { token ->
                _token.value = token
            }
        }
    }

    private fun loadSavedToken() {
        viewModelScope.launch {
            _token.value = getTokenUseCase.getSavedToken().first() // Получение первого элемента из Flow
        }
    }

}