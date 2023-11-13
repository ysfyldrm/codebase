package com.yy.codebasecase.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Uygulama genelinde kullanılacak singleton bağımlılıkları sağlar.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Context kırmızı çizgimiz :)
     */
    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }
}