package com.cyberleveling.di

import com.cyberleveling.data.database.dao.PlayerDao
import com.cyberleveling.workers.DailyResetWorker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkerModule {

    @Provides
    @Singleton
    fun providePlayerDao(database: CyberLevelingDatabase): PlayerDao {
        return database.userDao()
    }
}
