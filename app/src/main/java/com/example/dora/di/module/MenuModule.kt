package com.example.dora.di.module

import com.example.dora.model.MenuModel
import com.example.dora.datacache.model.PopMusic
import dagger.Module
import dagger.Provides
import dora.db.dao.DaoFactory
import dora.db.dao.OrmDao

/**
 * 菜单模块。
 */
@Module
class MenuModule {

    @Provides
    fun provideMenuModel(): MenuModel {
        return MenuModel()
    }
}