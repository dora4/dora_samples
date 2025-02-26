-keepattributes *Annotation*

-dontwarn com.alipay.sdk.app.H5PayCallback
-dontwarn com.alipay.sdk.app.PayTask
-dontwarn com.alipay.sdk.util.H5PayResultModel
-dontwarn com.download.library.DownloadImpl
-dontwarn com.download.library.DownloadListenerAdapter
-dontwarn com.download.library.DownloadTask
-dontwarn com.download.library.Extra
-dontwarn com.download.library.ResourceRequest
-dontwarn javax.lang.model.element.Element
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn org.slf4j.impl.StaticMDCBinder
-dontwarn org.slf4j.impl.StaticMarkerBinder

# ARouter
-keep class com.alibaba.android.arouter.** { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.IRouteGroup { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider { *; }
-keepclasseswithmembernames class * {
    @Autowired <fields>;
}
