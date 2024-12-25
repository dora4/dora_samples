package com.example.app.di.component

import android.app.Application
import com.example.common.di.module.AppModule
import dagger.Component

/**
 * APP组件。
 */
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: Application)
}