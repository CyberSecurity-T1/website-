package com.cyberleveling.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cyberleveling.core.theme.CyberLevelingTheme
// Make sure to import your DashboardScreen here once it is created
import com.cyberleveling.dashboard.DashboardScreen 
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CyberLevelingTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppRoot()
                }
            }
        }
    }
}

@Composable
private fun AppRoot() {
    // We replaced the empty placeholder with your actual starting Dashboard UI
    DashboardScreen(
        playerLevel = 1,
        playerRank = "Script Kiddie",
        totalXp = 0L
    )
}
