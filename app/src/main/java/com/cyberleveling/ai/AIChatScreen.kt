package com.cyberleveling.ai

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cyberleveling.core.theme.NeonCyan
import com.cyberleveling.core.theme.SystemBlack
import com.cyberleveling.core.theme.TerminalGreen

@Composable
fun AIChatScreen(
    uiState: ChatUiState,
    onSendMessage: (String) -> Unit
) {
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SystemBlack)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "AI TUTOR // SAFE EXPLANATIONS",
            style = MaterialTheme.typography.headlineMedium,
            color = NeonCyan,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.messages) { message ->
                val bgColor = if (message.sender == ChatMessage.Sender.USER) {
                    NeonCyan.copy(alpha = 0.18f)
                } else {
                    TerminalGreen.copy(alpha = 0.12f)
                }
                val textColor = if (message.sender == ChatMessage.Sender.USER) {
                    Color.White
                } else {
                    TerminalGreen
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, NeonCyan.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        .background(bgColor, RoundedCornerShape(12.dp))
                        .padding(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (message.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.padding(end = 8.dp),
                                color = TerminalGreen,
                                strokeWidth = 2.dp
                            )
                        }
                        Text(
                            text = message.text,
                            color = textColor,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        if (uiState.isLoading) {
            Text(
                text = "Loading response...",
                color = TerminalGreen,
                style = MaterialTheme.typography.labelMedium
            )
        }

        uiState.errorMessage?.let { error ->
            Text(
                text = error,
                color = Color(0xFFFF5A5F),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Ask for a safe hint...") },
                singleLine = true
            )

            TextButton(
                onClick = {
                    if (input.isNotBlank()) {
                        onSendMessage(input)
                        input = ""
                    }
                }
            ) {
                Text("Send")
            }
        }
    }
}
