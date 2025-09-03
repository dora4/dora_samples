package com.example.app.di.component

import com.example.app.MenuListActivity
import com.example.app.di.module.MenuModule
import dagger.Component

/**
 * 菜单组件。
 */
@Component(modules = [MenuModule::class], dependencies = [AppComponent::class])
interface MenuComponent {

    fun inject(activity: MenuListActivity)
}