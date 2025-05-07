package com.example.common

/**
 * ARouter的路径。
 */
interface ARouterPath {
    companion object {
        const val GROUP_MAIN: String = "Main"
        const val GROUP_DORA: String = "Dora"
        const val GROUP_CACHE: String = "Cache"
        const val GROUP_VIEW: String = "View"
        const val ACTIVITY_MENU_LIST: String = "/$GROUP_MAIN/MenuListActivity"
        const val ACTIVITY_INTRODUCE: String = "/$GROUP_DORA/IntroduceActivity"
        const val ACTIVITY_WEB_VIEW: String = "/$GROUP_DORA/WebViewActivity"
        const val ACTIVITY_EXTRAS: String = "/$GROUP_DORA/ExtrasActivity"
        const val ACTIVITY_EVENT_BUS: String = "/$GROUP_DORA/EventBusActivity"
        const val ACTIVITY_CRASH: String = "/$GROUP_DORA/CrashActivity"
        const val ACTIVITY_TIPS: String = "/$GROUP_DORA/TipsActivity"
        const val ACTIVITY_FLOW_PAGE: String = "/$GROUP_DORA/FlowPageActivity"
        const val ACTIVITY_NET_DETECT: String = "/$GROUP_DORA/NetDetectActivity"
        const val ACTIVITY_VIEW_MODEL_SAMPLE_1: String =
            "/$GROUP_DORA/ViewModelSample1Activity"
        const val ACTIVITY_VIEW_MODEL_SAMPLE_2: String =
            "/$GROUP_DORA/ViewModelSample2Activity"
        const val ACTIVITY_RSA: String = "/$GROUP_DORA/RsaActivity"
        const val ACTIVITY_WEB3_PAY: String = "/$GROUP_DORA/Web3PayActivity"
        const val ACTIVITY_ORM: String = "/$GROUP_CACHE/OrmActivity"
//        const val ACTIVITY_DATA_CACHE: String = "/$GROUP_CACHE/DataCacheActivity"
        const val ACTIVITY_PROGRESS_VIEW: String = "/$GROUP_VIEW/ProgressViewActivity"
        const val ACTIVITY_TITLE_BAR: String = "/$GROUP_VIEW/TitleBarActivity"
        const val ACTIVITY_TOGGLE_BUTTON: String = "/$GROUP_VIEW/ToggleButtonActivity"
        const val ACTIVITY_TOAST: String = "/$GROUP_VIEW/TipsActivity"
        const val ACTIVITY_TAB_LAYOUT: String = "/$GROUP_VIEW/TabLayoutActivity"
        const val ACTIVITY_ALERT_DIALOG: String = "/$GROUP_VIEW/AlertDialogActivity"
        const val ACTIVITY_LOADING_DIALOG: String = "/$GROUP_VIEW/LoadingDialogActivity"
        const val ACTIVITY_BOTTOM_DIALOG: String = "/$GROUP_VIEW/BottomDialogActivity"
        const val ACTIVITY_RADIO_GROUP: String = "/$GROUP_VIEW/RadioGroupActivity"
    }
}
