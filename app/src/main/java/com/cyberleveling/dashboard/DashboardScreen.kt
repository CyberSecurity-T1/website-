package com.cyberleveling.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cyberleveling.domain.usecase.XpSource

// Theme Colors (You can move these to your Color.kt file later)
val SystemBlack = Color(0xFF0B0F19)
val CardDark = Color(0xFF111827)
val NeonCyan = Color(0xFF00F3FF)
val ShadowPurple = Color(0xFF9333EA)
val TerminalGreen = Color(0xFF00FF00)

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel() // Hilt injects the ViewModel automatically!
) {
    // This observes the StateFlow from your ViewModel. 
    // Any time totalXp or Level changes, the UI automatically redraws.
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SystemBlack)
            .padding(16.dp)
    ) {
        // Player Status HUD
        StatusWindow(
            level = uiState.currentLevel,
            rank = uiState.rank,
            xp = uiState.totalXp,
            streak = uiState.currentStreak
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Active Quests Section
        Text("ACTIVE QUESTS", color = NeonCyan, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
        Spacer(modifier = Modifier.height(8.dp))
        
        QuestCard(
            title = "Complete Web Security Lab", 
            xp = 75,
            onClick = { viewModel.onXpEarned(XpSource.LAB) } // Triggers the ViewModel!
        )
        
        QuestCard(
            title = "Pass Cyber Quiz", 
            xp = 25,
            onClick = { viewModel.onXpEarned(XpSource.QUIZ) }
        )

        // Level Up Alert
        if (uiState.isLevelingUp) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "AWAKENING: LEVEL UP ACHIEVED!", 
                color = ShadowPurple, 
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun StatusWindow(level: Int, rank: String, xp: Int, streak: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, NeonCyan, RoundedCornerShape(8.dp))
            .background(CardDark.copy(alpha = 0.8f), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("HUNTER STATUS", color = Color.White, fontSize = 12.sp, letterSpacing = 2.sp)
                Text("🔥 $streak DAY STREAK", color = Color(0xFFFFA500), fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text("LVL $level", color = NeonCyan, fontSize = 36.sp, fontWeight = FontWeight.Black)
                Spacer(modifier = Modifier.width(12.dp))
                Text("[$rank]", color = ShadowPurple, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(12.dp))
            
            // Simulates XP to next level (e.g., assumes 100 XP per level for the UI bar)
            val progress = (xp % 100) / 100f
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = NeonCyan,
                trackColor = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("Total XP: $xp", color = Color.Gray, fontSize = 10.sp)
        }
    }
}

@Composable
fun QuestCard(title: String, xp: Int, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2937)),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(1.dp, Color.DarkGray, RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, color = Color.White)
            Text("+$xp XP", color = TerminalGreen, fontWeight = FontWeight.Bold)
        }
    }
}
