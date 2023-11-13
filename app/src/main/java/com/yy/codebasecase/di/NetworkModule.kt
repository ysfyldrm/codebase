package com.yy.codebasecase.di

import com.yy.codebasecase.network.client.KtorClient
import com.yy.codebasecase.network.service.PropertyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKtorClient(): KtorClient {
        return KtorClient
    }

    @Provides
    @Singleton
    fun providePropertyService(ktorClient: KtorClient): PropertyService {
        return PropertyService(ktorClient)
    }
}