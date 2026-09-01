package com.cyberleveling.domain.repository

data class CoursePath(
    val courseId: String,
    val title: String,
    val category: String,
    val xpReward: Int,
    val isCompleted: Boolean,
    val lessons: List<LessonProgress>
)

data class LessonProgress(
    val lessonId: String,
    val courseId: String,
    val title: String,
    val category: String,
    val xpReward: Int,
    val sortOrder: Int,
    val isCompleted: Boolean
)

interface AcademyRepository {
    suspend fun getCoursePaths(): List<CoursePath>
    suspend fun updateLessonCompletion(courseId: String, lessonId: String, isCompleted: Boolean)
}
