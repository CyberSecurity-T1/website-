package com.cyberleveling.data.database.dao

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import com.cyberleveling.data.database.entity.CourseEntity
import com.cyberleveling.data.database.entity.LessonEntity

data class CourseWithLessons(
    @Embedded val course: CourseEntity,
    @Relation(
        parentColumn = "course_id",
        entityColumn = "course_id"
    )
    val lessons: List<LessonEntity>
)

@Dao
interface CourseDao {
    @Transaction
    @Query("SELECT * FROM courses ORDER BY title ASC")
    suspend fun getAllCoursesWithLessons(): List<CourseWithLessons>

    @Query("UPDATE courses SET is_completed = :isCompleted WHERE course_id = :courseId")
    suspend fun updateCourseCompletion(courseId: String, isCompleted: Boolean): Int
}
