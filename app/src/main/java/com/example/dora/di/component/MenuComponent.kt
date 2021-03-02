package com.example.dora.di.component

import com.example.dora.MenuListActivity
import com.example.dora.di.module.MenuModule
import com.example.dora.ui.DataCacheActivity
import dagger.Component

/**
 * 菜单组件。
 */
@Component(modules = arrayOf(MenuModule::class), dependencies = arrayOf(AppComponent::class))
interface MenuComponent {

    fun inject(activity: MenuListActivity)
    fun inject(activity: DataCacheActivity)
}