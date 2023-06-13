package com.example.dora.model

import android.graphics.Color
import com.example.dora.ARouterPath
import com.example.dora.bean.Menu

/**
 * 先生，您要来点什么？以下就是本游乐园所有支持的功能哦！
 */
class MenuModel {

    /**
     * 不同的颜色代表不同的板块哦，比如：
     * MAGENTA（紫色）：代表导游
     * GRAY（灰色）：代表MVVM
     * GREEN（绿色）：代表自定义控件
     * BLACK（黑色）：代表音视频
     */
    fun loadMenus(): MutableList<Menu> {
        return mutableListOf(
            Menu(Color.MAGENTA, "游乐园简介", ARouterPath.ACTIVITY_INTRODUCE),
            Menu(Color.MAGENTA, "Star收藏一下不迷路", ARouterPath.ACTIVITY_WEB_VIEW),
            Menu(Color.GRAY, "RSA加密", ARouterPath.ACTIVITY_RSA),
            Menu(Color.GRAY, "ORM数据存储——基于dora-db", ARouterPath.ACTIVITY_ORM),
            Menu(Color.GRAY, "数据的三级缓存（断网加载缓存数据）", ARouterPath.ACTIVITY_DATA_CACHE),
            Menu(Color.GRAY, "有用的小提示", ARouterPath.ACTIVITY_TIPS),
            Menu(Color.GRAY, "Intent传参", ARouterPath.ACTIVITY_EXTRAS)
        )
    }
}