package com.cyberleveling.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val userId: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "current_level")
    val currentLevel: Int,

    @ColumnInfo(name = "total_xp")
    val totalXp: Int,

    @ColumnInfo(name = "current_rank")
    val currentRank: String,

    @ColumnInfo(name = "current_streak")
    val currentStreak: Int
)
