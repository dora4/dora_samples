package com.example.dora.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dora.util.GlobalContext
import javax.inject.Singleton

/**
 * 菜单模块。
 */
@Module
class MenuModule {

    @Provides
    @Singleton
    fun provideContext(): Application {
        return GlobalContext.get()
    }
}