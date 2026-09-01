package com.cyberleveling.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cyberleveling.data.database.dao.CourseDao
import com.cyberleveling.data.database.dao.LessonDao
import com.cyberleveling.data.database.dao.PlayerDao
import com.cyberleveling.data.database.entity.AchievementEntity
import com.cyberleveling.data.database.entity.CourseEntity
import com.cyberleveling.data.database.entity.LessonEntity
import com.cyberleveling.data.database.entity.UserEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(
    entities = [
        UserEntity::class,
        CourseEntity::class,
        LessonEntity::class,
        AchievementEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CyberLevelingDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun courseDao(): CourseDao
    abstract fun lessonDao(): LessonDao
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CyberLevelingDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CyberLevelingDatabase::class.java,
            "cyber_leveling_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePlayerDao(database: CyberLevelingDatabase): PlayerDao {
        return database.playerDao()
    }

    @Provides
    @Singleton
    fun provideCourseDao(database: CyberLevelingDatabase): CourseDao {
        return database.courseDao()
    }

    @Provides
    @Singleton
    fun provideLessonDao(database: CyberLevelingDatabase): LessonDao {
        return database.lessonDao()
    }
}
