package com.cyberleveling.di

import com.cyberleveling.data.repository.AcademyRepositoryImpl
import com.cyberleveling.domain.repository.AcademyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAcademyRepository(
        repositoryImpl: AcademyRepositoryImpl
    ): AcademyRepository
}
