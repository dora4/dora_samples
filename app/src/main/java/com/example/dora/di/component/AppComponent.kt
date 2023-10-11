package com.example.dora.di.component

import android.app.Application
import com.example.dora.di.module.AppModule
import dagger.Component

/**
 * APP组件。
 */
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: Application)
}