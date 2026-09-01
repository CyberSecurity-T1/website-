package com.cyberleveling.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achievements")
data class AchievementEntity(
    @PrimaryKey
    @ColumnInfo(name = "achievement_id")
    val achievementId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "requirement")
    val requirement: String,

    @ColumnInfo(name = "is_unlocked")
    val isUnlocked: Boolean = false
)
