package com.example.common.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * APP模块。
 */
@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Application {
        return app
    }
}