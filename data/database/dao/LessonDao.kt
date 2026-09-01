package com.cyberleveling.data.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons WHERE course_id = :courseId ORDER BY sort_order ASC")
    suspend fun getLessonsForCourse(courseId: String): List<com.cyberleveling.data.database.entity.LessonEntity>

    @Query("UPDATE lessons SET is_completed = :isCompleted WHERE lesson_id = :lessonId")
    suspend fun updateLessonCompletion(lessonId: String, isCompleted: Boolean): Int
}
