package com.cyberleveling.labs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyberleveling.core.theme.NeonCyan
import com.cyberleveling.core.theme.SystemBlack
import com.cyberleveling.core.theme.TerminalGreen

@Composable
fun LabTerminalScreen(
    commandHistory: List<String> = emptyList(),
    onSubmitCommand: (String) -> Unit = {}
) {
    var commandText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SystemBlack)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "LAB TERMINAL // SAFE SANDBOX",
            style = MaterialTheme.typography.headlineMedium,
            color = NeonCyan
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .border(1.dp, NeonCyan.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                .background(Color(0xFF071219), RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(commandHistory.ifEmpty { listOf("user@lab:~$ ls", "bin  etc  home  lab-data", "user@lab:~$") }) { line ->
                    Text(
                        text = line,
                        color = if (line.startsWith("user@lab")) TerminalGreen else NeonCyan,
                        style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 13.sp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, NeonCyan.copy(alpha = 0.7f), RoundedCornerShape(10.dp))
                .background(Color(0xFF0E1724), RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "root@lab:~$",
                color = TerminalGreen,
                style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 14.sp)
            )

            Box(modifier = Modifier.width(12.dp))

            BasicTextField(
                value = commandText,
                onValueChange = { commandText = it },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontSize = 14.sp,
                    color = NeonCyan
                ),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (commandText.isEmpty()) {
                        Text("type command...", color = NeonCyan.copy(alpha = 0.5f))
                    }
                    innerTextField()
                }
            )
        }

        androidx.compose.material3.Button(
            onClick = {
                if (commandText.isNotBlank()) {
                    onSubmitCommand(commandText.trim())
                    commandText = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = NeonCyan,
                contentColor = SystemBlack
            )
        ) {
            Text(text = "EXECUTE")
        }
    }
}
