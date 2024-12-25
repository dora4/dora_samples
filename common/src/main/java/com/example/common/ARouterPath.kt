package com.example.common

/**
 * ARouter的路径。
 */
interface ARouterPath {
    companion object {
        const val GROUP_MAIN: String = "Main"
        const val GROUP_CACHE: String = "Cache"
        const val GROUP_VIEW: String = "View"
        const val ACTIVITY_INTRODUCE: String = "/$GROUP_MAIN/IntroduceActivity"
        const val ACTIVITY_MENU_LIST: String = "/$GROUP_MAIN/MenuListActivity"
        const val ACTIVITY_WEB_VIEW: String = "/$GROUP_MAIN/WebViewActivity"
        const val ACTIVITY_EXTRAS: String = "/$GROUP_MAIN/ExtrasActivity"
        const val ACTIVITY_EVENT_BUS: String = "/$GROUP_MAIN/EventBusActivity"
        const val ACTIVITY_CRASH: String = "/$GROUP_MAIN/CrashActivity"
        const val ACTIVITY_TIPS: String = "/$GROUP_MAIN/TipsActivity"
        const val ACTIVITY_FLOW_PAGE: String = "/$GROUP_MAIN/FlowPageActivity"
        const val ACTIVITY_NET_DETECT: String = "/$GROUP_MAIN/NetDetectActivity"
        const val ACTIVITY_VIEW_MODEL_SAMPLE_1: String =
            "/$GROUP_MAIN/ViewModelSample1Activity"
        const val ACTIVITY_VIEW_MODEL_SAMPLE_2: String =
            "/$GROUP_MAIN/ViewModelSample2Activity"
        const val ACTIVITY_ORM: String = "/$GROUP_CACHE/OrmActivity"
        const val ACTIVITY_RSA: String = "/$GROUP_MAIN/RsaActivity"
        const val ACTIVITY_DATA_CACHE: String = "/$GROUP_CACHE/DataCacheActivity"
        const val ACTIVITY_PROGRESS_VIEW: String = "/$GROUP_VIEW/ProgressViewActivity"
        const val ACTIVITY_TITLE_BAR: String = "/$GROUP_VIEW/TitleBarActivity"
        const val ACTIVITY_ALERT_DIALOG: String = "/$GROUP_VIEW/AlertDialogActivity"
        const val ACTIVITY_LOADING_DIALOG: String = "/$GROUP_VIEW/LoadingDialogActivity"
    }
}
