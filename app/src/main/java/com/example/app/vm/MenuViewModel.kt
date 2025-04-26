package com.example.app.vm

import android.graphics.Color
import com.example.app.MenuListAdapter
import com.example.app.bean.Menu
import com.example.common.ARouterPath
import com.example.common.Colors
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
     * PINK（粉色）：代表引言
     * BLACK（黑色）：代表dora基础架构
     * CYAN（青色）：代表dview自定义控件
     * BLUE（蓝色）：代表dcache数据缓存
     */
    private fun initMenus(): MutableList<Menu> {
        return mutableListOf(
            Menu(Colors.PINK, "游乐园简介", ARouterPath.ACTIVITY_INTRODUCE),
            Menu(Colors.PINK, "Star收藏一下不迷路", ARouterPath.ACTIVITY_WEB_VIEW),
            Menu(Colors.BLACK, "将崩溃日志写入文件", ARouterPath.ACTIVITY_CRASH),
            Menu(Colors.BLACK, "有用的小提示ToastUtils", ARouterPath.ACTIVITY_TIPS),
            Menu(Colors.BLACK, "Intent传参", ARouterPath.ACTIVITY_EXTRAS),
            Menu(Colors.BLACK, "Fragment流式切换", ARouterPath.ACTIVITY_FLOW_PAGE),
//            Menu(Colors.BLACK "使用EventBus扩展包", ARouterPath.ACTIVITY_EVENT_BUS),
            Menu(Colors.BLACK, "RSA加密", ARouterPath.ACTIVITY_RSA),
            Menu(Colors.BLACK, "网络状态探测", ARouterPath.ACTIVITY_NET_DETECT),
            Menu(Colors.BLACK, "Web3支付", ARouterPath.ACTIVITY_WEB3_PAY),
            Menu(Colors.BLACK, "ViewModel示例1", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_1),
            Menu(Colors.BLACK, "ViewModel示例2", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_2),
            Menu(Colors.SKY_BLUE, "仿抖音极速版领现金进度条动画", ARouterPath.ACTIVITY_PROGRESS_VIEW),
            Menu(Colors.SKY_BLUE, "一个标题栏控件", ARouterPath.ACTIVITY_TITLE_BAR),
            Menu(Colors.SKY_BLUE, "系统提示信息对话框", ARouterPath.ACTIVITY_ALERT_DIALOG),
            Menu(Colors.SKY_BLUE, "加载中对话框", ARouterPath.ACTIVITY_LOADING_DIALOG),
            Menu(Colors.SKY_BLUE, "自定义吐司", ARouterPath.ACTIVITY_TOAST),
            Menu(Colors.SKY_BLUE, "Tab分页", ARouterPath.ACTIVITY_TAB_LAYOUT),
            Menu(Colors.GREEN, "ORM数据存储——基于dora-db", ARouterPath.ACTIVITY_ORM),
//            Menu(Color.BLUE, "数据缓存（断网情况加载缓存数据）", ARouterPath.ACTIVITY_DATA_CACHE)
        )
    }
}