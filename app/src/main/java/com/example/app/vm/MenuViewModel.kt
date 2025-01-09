package com.example.app.vm

import android.graphics.Color
import com.example.app.MenuListAdapter
import com.example.app.bean.Menu
import com.example.common.ARouterPath
import com.example.common.vm.BaseViewModel

/**
 * 菜单列表。
 */
class MenuViewModel : BaseViewModel() {

    init {
        // 一行代码完成数据的配置
        adapter.set(MenuListAdapter(initMenus()))
    }

    /**
     * MAGENTA（紫色）：代表引言
     * GRAY（灰色）：代表dora基础架构
     * CYAN（青色）：代表dview自定义控件
     * BLUE（蓝色）：代表dcache数据缓存
     */
    private fun initMenus(): MutableList<Menu> {
        return mutableListOf(
            Menu(Color.MAGENTA, "游乐园简介", ARouterPath.ACTIVITY_INTRODUCE),
            Menu(Color.MAGENTA, "Star收藏一下不迷路", ARouterPath.ACTIVITY_WEB_VIEW),
            Menu(Color.GRAY, "将Crash写入文件", ARouterPath.ACTIVITY_CRASH),
            Menu(Color.GRAY, "有用的小提示ToastUtils", ARouterPath.ACTIVITY_TIPS),
            Menu(Color.GRAY, "Intent传参", ARouterPath.ACTIVITY_EXTRAS),
            Menu(Color.GRAY, "Fragment流式切换", ARouterPath.ACTIVITY_FLOW_PAGE),
//            Menu(Color.GRAY, "使用EventBus扩展包", ARouterPath.ACTIVITY_EVENT_BUS),
            Menu(Color.GRAY, "RSA加密", ARouterPath.ACTIVITY_RSA),
            Menu(Color.GRAY, "网络状态探测", ARouterPath.ACTIVITY_NET_DETECT),
            Menu(Color.GRAY, "ViewModel示例1", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_1),
            Menu(Color.GRAY, "ViewModel示例2", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_2),
            Menu(Color.CYAN, "仿抖音极速版领现金进度条动画", ARouterPath.ACTIVITY_PROGRESS_VIEW),
            Menu(Color.CYAN, "一个标题栏控件", ARouterPath.ACTIVITY_TITLE_BAR),
            Menu(Color.CYAN, "系统提示信息对话框", ARouterPath.ACTIVITY_ALERT_DIALOG),
            Menu(Color.CYAN, "加载中对话框", ARouterPath.ACTIVITY_LOADING_DIALOG),
            Menu(Color.CYAN, "自定义吐司", ARouterPath.ACTIVITY_TOAST),
            Menu(Color.BLUE, "ORM数据存储——基于dora-db", ARouterPath.ACTIVITY_ORM),
//            Menu(Color.BLUE, "数据缓存（断网情况加载缓存数据）", ARouterPath.ACTIVITY_DATA_CACHE)
        )
    }
}