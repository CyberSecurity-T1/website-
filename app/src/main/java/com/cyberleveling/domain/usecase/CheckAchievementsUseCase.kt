package com.cyberleveling.domain.usecase

import javax.inject.Inject

class CheckAchievementsUseCase @Inject constructor() {

    fun execute(totalLabsCompleted: Int, userLevel: Int): List<String> {
        val unlocked = mutableListOf<String>()

        if (totalLabsCompleted >= 10) {
            unlocked.add("Complete 10 Labs")
        }

        if (userLevel >= 50) {
            unlocked.add("Reach Level 50")
        }

        return unlocked
    }
}
