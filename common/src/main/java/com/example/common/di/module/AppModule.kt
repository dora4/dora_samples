package com.example.common.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * APP模块。
 */
@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Application {
        return app
    }

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }
}
