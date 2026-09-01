package com.cyberleveling.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey
    @ColumnInfo(name = "course_id")
    val courseId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "xp_reward")
    val xpReward: Int,

    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false
)
