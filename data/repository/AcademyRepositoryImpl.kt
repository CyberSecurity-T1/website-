package com.cyberleveling.data.repository

import com.cyberleveling.data.database.dao.CourseDao
import com.cyberleveling.data.database.dao.LessonDao
import com.cyberleveling.domain.repository.AcademyRepository
import com.cyberleveling.domain.repository.CoursePath
import com.cyberleveling.domain.repository.LessonProgress
import javax.inject.Inject

class AcademyRepositoryImpl @Inject constructor(
    private val courseDao: CourseDao,
    private val lessonDao: LessonDao
) : AcademyRepository {

    override suspend fun getCoursePaths(): List<CoursePath> {
        return courseDao.getAllCoursesWithLessons().map { courseWithLessons ->
            CoursePath(
                courseId = courseWithLessons.course.courseId,
                title = courseWithLessons.course.title,
                category = courseWithLessons.course.category,
                xpReward = courseWithLessons.course.xpReward,
                isCompleted = courseWithLessons.course.isCompleted,
                lessons = courseWithLessons.lessons.map { lesson ->
                    LessonProgress(
                        lessonId = lesson.lessonId,
                        courseId = lesson.courseId,
                        title = lesson.title,
                        category = lesson.category,
                        xpReward = lesson.xpReward,
                        sortOrder = lesson.sortOrder,
                        isCompleted = lesson.isCompleted
                    )
                }
            )
        }
    }

    override suspend fun updateLessonCompletion(courseId: String, lessonId: String, isCompleted: Boolean) {
        lessonDao.updateLessonCompletion(lessonId, isCompleted)
    }
}
