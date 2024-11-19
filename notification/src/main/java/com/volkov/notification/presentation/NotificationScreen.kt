package com.volkov.notification.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NotificationScreen(viewModel: NotificationViewModel) {
    val token by viewModel.token.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Your Firebase Token:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        var textState by remember { mutableStateOf(token) }

        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Token") },
            singleLine = false,
            modifier = Modifier.height(IntrinsicSize.Min)
        )
    }
}