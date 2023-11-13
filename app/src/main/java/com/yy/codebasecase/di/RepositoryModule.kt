package com.yy.codebasecase.di

import com.yy.codebasecase.data.repository.PropertyRepository
import com.yy.codebasecase.data.repository.PropertyRepositoryImpl
import com.yy.codebasecase.network.service.PropertyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePropertyRepository(propertyService: PropertyService): PropertyRepository {
        return PropertyRepositoryImpl(propertyService)
    }
}