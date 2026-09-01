package com.cyberleveling.domain.usecase

import com.cyberleveling.domain.model.CyberRank
import javax.inject.Inject

enum class XpSource(val xpEarned: Int) {
    LESSON(10),
    QUIZ(25),
    LAB(75)
}

data class XpProgress(
    val previousLevel: Int,
    val currentLevel: Int,
    val previousTotalXp: Int,
    val totalXp: Int,
    val gainedXp: Int,
    val leveledUp: Boolean,
    val currentRank: CyberRank
)

class CalculateXpUseCase @Inject constructor() {

    fun execute(currentLevel: Int, totalXp: Int, source: XpSource): XpProgress {
        val previousLevel = currentLevel.coerceAtLeast(1)
        val gainedXp = source.xpEarned
        val newTotalXp = totalXp + gainedXp
        val newLevel = calculateLevel(newTotalXp)

        return XpProgress(
            previousLevel = previousLevel,
            currentLevel = newLevel,
            previousTotalXp = totalXp,
            totalXp = newTotalXp,
            gainedXp = gainedXp,
            leveledUp = newLevel > previousLevel,
            currentRank = CyberRank.fromLevel(newLevel)
        )
    }

    fun calculateLevel(totalXp: Int): Int {
        if (totalXp < 0) return 1
        return (totalXp / XP_PER_LEVEL) + 1
    }

    companion object {
        private const val XP_PER_LEVEL = 100
    }
}
