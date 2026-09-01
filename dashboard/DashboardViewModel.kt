package com.cyberleveling.dashboard

import androidx.lifecycle.ViewModel
import com.cyberleveling.domain.model.CyberRank
import com.cyberleveling.domain.usecase.CalculateXpUseCase
import com.cyberleveling.domain.usecase.XpSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class DashboardUiState(
    val currentLevel: Int = 1,
    val totalXp: Int = 0,
    val rank: String = CyberRank.titleForLevel(1),
    val currentStreak: Int = 0,
    val isLevelingUp: Boolean = false
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val calculateXpUseCase: CalculateXpUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    fun onXpEarned(source: XpSource) {
        val currentState = _uiState.value
        val progress = calculateXpUseCase.execute(
            currentLevel = currentState.currentLevel,
            totalXp = currentState.totalXp,
            source = source
        )

        _uiState.update {
            it.copy(
                currentLevel = progress.currentLevel,
                totalXp = progress.totalXp,
                rank = progress.currentRank.title,
                isLevelingUp = progress.leveledUp
            )
        }
    }

    fun onDailyStreakIncrement() {
        _uiState.update { it.copy(currentStreak = it.currentStreak + 1) }
    }
}
