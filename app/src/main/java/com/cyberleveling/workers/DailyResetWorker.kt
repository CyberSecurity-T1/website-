package com.cyberleveling.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.cyberleveling.data.database.dao.PlayerDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.Calendar

class DailyResetWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val playerDao: PlayerDao
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        return try {
            val today = Calendar.getInstance()
            val hour = today.get(Calendar.HOUR_OF_DAY)
            val minute = today.get(Calendar.MINUTE)

            val currentTime = hour * 60 + minute
            val midnightThreshold = 0

            val resetDailyQuests = true
            val shouldLoseStreak = currentTime >= midnightThreshold

            if (shouldLoseStreak) {
                // Example: reset or recalculate daily progress in repository logic; kept separate from UI.
            }

            Result.success(
                workDataOf(
                    "daily_quests_reset" to resetDailyQuests,
                    "streak_lost" to shouldLoseStreak
                )
            )
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
