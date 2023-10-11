package com.example.dora.di.component

import com.example.dora.MenuListActivity
import com.example.dora.di.module.MenuModule
import com.example.dora.ui.DataCacheActivity
import dagger.Component

/**
 * 菜单组件。
 */
@Component(modules = [MenuModule::class], dependencies = [AppComponent::class])
interface MenuComponent {

    fun inject(activity: MenuListActivity)
    fun inject(activity: DataCacheActivity)
}