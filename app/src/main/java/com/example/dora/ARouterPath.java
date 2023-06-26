package com.example.dora;

/**
 * 这是一张本游乐园全景地图，可以告诉你哪个地方怎么走。
 */
public interface ARouterPath {

    String GROUP_MAIN = "/Main";
    String ACTIVITY_INTRODUCE = GROUP_MAIN + "/IntroduceActivity";
    String ACTIVITY_MENU_LIST = GROUP_MAIN + "/MenuListActivity";
    String ACTIVITY_WEB_VIEW = GROUP_MAIN + "/WebViewActivity";
    String ACTIVITY_EXTRAS = GROUP_MAIN + "/ExtrasActivity";
    String ACTIVITY_EVENT_BUS = GROUP_MAIN + "/EventBusActivity";
    String ACTIVITY_CRASH = GROUP_MAIN + "/CrashActivity";
    String ACTIVITY_TIPS = GROUP_MAIN + "/TipsActivity";
    String ACTIVITY_ORM = GROUP_MAIN + "/OrmActivity";
    String ACTIVITY_RSA = GROUP_MAIN + "/RsaActivity";
    String ACTIVITY_DATA_CACHE = GROUP_MAIN + "/DataCacheActivity";
    String ACTIVITY_PROGRESS_VIEW = GROUP_MAIN + "/ProgressViewActivity";
    String ACTIVITY_TITLE_BAR = GROUP_MAIN + "/TitleBarActivity";
    String ACTIVITY_ALERT_DIALOG = GROUP_MAIN + "/AlertDialogActivity";
}
