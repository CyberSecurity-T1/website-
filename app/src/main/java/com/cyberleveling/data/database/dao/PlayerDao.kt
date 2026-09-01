package com.cyberleveling.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.cyberleveling.data.database.entity.UserEntity

@Dao
interface PlayerDao {

    @Query("SELECT * FROM users WHERE user_id = :userId LIMIT 1")
    suspend fun getPlayer(userId: String): UserEntity?

    @Query("UPDATE users SET total_xp = total_xp + :xp WHERE user_id = :userId")
    suspend fun updateXp(userId: String, xp: Int): Int

    @Query("UPDATE users SET current_level = :level WHERE user_id = :userId")
    suspend fun updateLevel(userId: String, level: Int): Int

    @Query("UPDATE users SET current_streak = current_streak + 1 WHERE user_id = :userId")
    suspend fun incrementDailyStreak(userId: String): Int
}
