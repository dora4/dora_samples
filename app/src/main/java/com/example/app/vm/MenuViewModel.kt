package com.example.app.vm

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
     * GIRL_PINK（少女粉）：代表引言
     * OBSIDIAN_BLACK（曜石黑）：代表dora基础架构
     * SKY_BLUE（天蓝）：代表dview自定义控件
     * LEAF_GREEN（叶绿）：代表dcache数据缓存
     */
    private fun initMenus(): MutableList<Menu> {
        return mutableListOf(
            Menu(Colors.GIRL_PINK, "游乐园简介", ARouterPath.ACTIVITY_INTRODUCE),
            Menu(Colors.GIRL_PINK, "Star收藏一下不迷路", ARouterPath.ACTIVITY_WEB_VIEW),
            Menu(Colors.OBSIDIAN_BLACK, "将崩溃日志写入文件", ARouterPath.ACTIVITY_CRASH),
            Menu(Colors.OBSIDIAN_BLACK, "忽略调用线程的吐司", ARouterPath.ACTIVITY_TIPS),
            Menu(Colors.OBSIDIAN_BLACK, "ARouter路由Intent传参", ARouterPath.ACTIVITY_EXTRAS),
            Menu(Colors.OBSIDIAN_BLACK, "ARouter组件化路由", ARouterPath.ACTIVITY_ROUTE),
            Menu(Colors.OBSIDIAN_BLACK, "Fragment流式切换", ARouterPath.ACTIVITY_FLOW_PAGE),
//            Menu(Colors.OBSIDIAN_BLACK "使用EventBus扩展包", ARouterPath.ACTIVITY_EVENT_BUS),
            Menu(Colors.OBSIDIAN_BLACK, "RSA加密", ARouterPath.ACTIVITY_RSA),
//            Menu(Colors.OBSIDIAN_BLACK, "网络状态探测", ARouterPath.ACTIVITY_NET_DETECT),
            Menu(Colors.OBSIDIAN_BLACK, "Web3支付", ARouterPath.ACTIVITY_WEB3_PAY),
            Menu(Colors.OBSIDIAN_BLACK, "蒲公英分发集成", ARouterPath.ACTIVITY_PGYER),
            Menu(Colors.OBSIDIAN_BLACK, "ViewModel示例1", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_1),
            Menu(Colors.OBSIDIAN_BLACK, "ViewModel示例2", ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_2),

//            Menu(Colors.SKY_BLUE, "短视频极速版领现金进度条动画", ARouterPath.ACTIVITY_PROGRESS_VIEW),
            Menu(Colors.SKY_BLUE, "一个标题栏控件", ARouterPath.ACTIVITY_TITLE_BAR),
            Menu(Colors.SKY_BLUE, "菜单面板", ARouterPath.ACTIVITY_MENU_PANEL),
            Menu(Colors.SKY_BLUE, "系统提示信息对话框", ARouterPath.ACTIVITY_ALERT_DIALOG),
            Menu(Colors.SKY_BLUE, "进度条对话框", ARouterPath.ACTIVITY_LOADING_DIALOG),
            Menu(Colors.SKY_BLUE, "自定义吐司", ARouterPath.ACTIVITY_TOAST),
//            Menu(Colors.SKY_BLUE, "Tab分页", ARouterPath.ACTIVITY_TAB_LAYOUT),
            Menu(Colors.SKY_BLUE, "滑块按钮", ARouterPath.ACTIVITY_TOGGLE_BUTTON),
            Menu(Colors.SKY_BLUE, "底部弹窗", ARouterPath.ACTIVITY_BOTTOM_DIALOG),
            Menu(Colors.SKY_BLUE, "单选按钮（支持多行显示）", ARouterPath.ACTIVITY_RADIO_GROUP),
            Menu(Colors.SKY_BLUE, "空态布局", ARouterPath.ACTIVITY_EMPTY_LAYOUT),
            Menu(Colors.SKY_BLUE, "弹性容器", ARouterPath.ACTIVITY_FLEXIBLE_SCROLL_VIEW),
            Menu(Colors.SKY_BLUE, "下拉刷新&上拉加载", ARouterPath.ACTIVITY_SWIPE_LAYOUT),
            Menu(Colors.SKY_BLUE, "网格布局", ARouterPath.ACTIVITY_GRID_VIEW),
            Menu(Colors.SKY_BLUE, "卡券控件", ARouterPath.ACTIVITY_COUPON_VIEW),
            Menu(Colors.SKY_BLUE, "流式布局", ARouterPath.ACTIVITY_FLOW_LAYOUT),
            Menu(Colors.SKY_BLUE, "图标文字控件", ARouterPath.ACTIVITY_ICON_LABEL),
            Menu(Colors.SKY_BLUE, "侧滑删除控件", ARouterPath.ACTIVITY_SWIPE_MENU),
            Menu(Colors.SKY_BLUE, "通知红点控件", ARouterPath.ACTIVITY_BADGE_VIEW),
//            Menu(Colors.SKY_BLUE, "底部导航控件", ARouterPath.ACTIVITY_BOTTOM_BAR),
            Menu(Colors.SKY_BLUE, "环形进度条", ARouterPath.ACTIVITY_PROGRESS_BAR),
            Menu(Colors.SKY_BLUE, "购物车增减商品控件", ARouterPath.ACTIVITY_ADD_SUB_VIEW),
            Menu(Colors.SKY_BLUE, "下拉面板", ARouterPath.ACTIVITY_DROP_DOWN_LAYOUT),
            Menu(Colors.SKY_BLUE, "带清空按钮文本输入框", ARouterPath.ACTIVITY_CLEAR_EDIT_TEXT),
            Menu(Colors.SKY_BLUE, "图表引擎", ARouterPath.ACTIVITY_CHARTS),
            Menu(Colors.SKY_BLUE, "双指缩放控件", ARouterPath.ACTIVITY_PINCH_ZOOM_LAYOUT),
            Menu(Colors.SKY_BLUE, "侧边字母导航条", ARouterPath.ACTIVITY_SIDE_BAR),
            Menu(Colors.SKY_BLUE, "骨架屏加载控件", ARouterPath.ACTIVITY_SKELETON_VIEW),
            Menu(Colors.SKY_BLUE, "高亮炫光控件", ARouterPath.ACTIVITY_FLASH_VIEW),
            Menu(Colors.SKY_BLUE, "自动圆角按钮控件", ARouterPath.ACTIVITY_BUTTON),
            Menu(Colors.SKY_BLUE, "通知翻转控件", ARouterPath.ACTIVITY_FLIPPER_VIEW),
//            Menu(Colors.SKY_BLUE, "视差动画引导页", ARouterPath.ACTIVITY_PARALLAX_LAYOUT),
            Menu(Colors.SKY_BLUE, "头像裁剪", ARouterPath.ACTIVITY_AVATAR),


            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 插入数据", ARouterPath.ACTIVITY_ORM_INSERT_DATA),
            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 删除数据", ARouterPath.ACTIVITY_ORM_DELETE_DATA),
            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 更新数据", ARouterPath.ACTIVITY_ORM_UPDATE_DATA),
            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 查询数据", ARouterPath.ACTIVITY_ORM_QUERY_DATA),
            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 事务操作", ARouterPath.ACTIVITY_ORM_TRANSACTION),
            Menu(Colors.LEAF_GREEN, "ORM数据存储 - 转换器", ARouterPath.ACTIVITY_ORM_CONVERTER),
            Menu(Colors.LEAF_GREEN, "非列表数据缓存", ARouterPath.ACTIVITY_CACHE_NON_LIST_DATA),
            Menu(Colors.LEAF_GREEN, "列表数据缓存", ARouterPath.ACTIVITY_CACHE_LIST_DATA),
            Menu(Colors.LEAF_GREEN, "分页缓存", ARouterPath.ACTIVITY_CACHE_BATCH),
            Menu(Colors.LEAF_GREEN, "缓存数据分页", ARouterPath.ACTIVITY_CACHE_PAGER),
//            Menu(Color.LEAF_GREEN, "数据缓存（断网情况加载缓存数据）", ARouterPath.ACTIVITY_DATA_CACHE)
        )
    }
}