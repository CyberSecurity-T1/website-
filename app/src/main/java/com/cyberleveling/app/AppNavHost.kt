package com.cyberleveling.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cyberleveling.academy.AcademyScreen
import com.cyberleveling.ai.AIChatScreen
import com.cyberleveling.ai.ChatUiState
import com.cyberleveling.core.theme.NeonCyan
import com.cyberleveling.core.theme.SystemBlack
import com.cyberleveling.labs.LabTerminalScreen
import com.cyberleveling.profile.UserProfileScreen

@Composable
fun AppNavHost() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SystemBlack)
            .padding(16.dp)
    ) {
        Text(
            text = "CYBER LEVELING // COMMAND CENTER",
            style = MaterialTheme.typography.headlineMedium,
            color = NeonCyan
        )

        AcademyScreen(
            courses = emptyList()
        )

        LabTerminalScreen(
            commandHistory = listOf(
                "user@lab:~$ ls",
                "bin  etc  home  safe-lab",
                "user@lab:~$"
            ),
            onSubmitCommand = {}
        )

        AIChatScreen(
            uiState = ChatUiState(),
            onSendMessage = {}
        )

        UserProfileScreen()
    }
}
