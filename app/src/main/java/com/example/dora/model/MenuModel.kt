package com.example.dora.model

import android.graphics.Color
import com.example.dora.ARouterPath
import com.example.dora.bean.Menu

/**
 * 以下就是本游乐园支持的所有功能！
 */
class MenuModel {

    /**
     * 不同的颜色代表不同的板块哦，比如：
     * MAGENTA（紫色）：代表导游
     * GRAY（灰色）：代表dora基础架构
     * GREEN（绿色）：代表dview自定义控件
     * BLUE（蓝色）：代表dcache数据缓存
     */
    fun loadMenus(): MutableList<Menu> {
        return mutableListOf(
            Menu(Color.MAGENTA, "游乐园简介", ARouterPath.ACTIVITY_INTRODUCE),
            Menu(Color.MAGENTA, "Star收藏一下不迷路", ARouterPath.ACTIVITY_WEB_VIEW),
            Menu(Color.GRAY, "将Crash写入文件", ARouterPath.ACTIVITY_CRASH),
            Menu(Color.GRAY, "有用的小提示ToastUtils", ARouterPath.ACTIVITY_TIPS),
            Menu(Color.GRAY, "Intent传参", ARouterPath.ACTIVITY_EXTRAS),
            Menu(Color.GRAY, "RSA加密", ARouterPath.ACTIVITY_RSA),
            Menu(Color.BLUE, "ORM数据存储——基于dora-db", ARouterPath.ACTIVITY_ORM),
            Menu(Color.BLUE, "数据缓存（断网情况加载缓存数据）", ARouterPath.ACTIVITY_DATA_CACHE)
        )
    }
}