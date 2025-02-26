# 保留所有注解
-keep @interface * { *; }
# 确保注解的元数据不会被移除
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
-dontwarn javax.lang.model.element.Modifier
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

# 保留 GlobalConfig 接口的所有实现类
-keep class * implements dora.lifecycle.config.GlobalConfig { *; }
# 保留所有实现了 androidx.lifecycle.ViewModel 的类
-keep class androidx.lifecycle.ViewModel { *; }
# 保留所有继承自 androidx.lifecycle.ViewModel 的子类
-keep class * extends androidx.lifecycle.ViewModel { *; }
# 保留 BaseVMActivity 类本身
-keep class dora.BaseVMActivity { *; }
# 保留所有继承自 BaseVMActivity 的子类
-keep class * extends dora.BaseVMActivity { *; }
# 保留 BaseVMFragment 类本身
-keep class dora.BaseVMFragment { *; }
# 保留所有继承自 BaseVMFragment 的子类
-keep class * extends dora.BaseVMFragment { *; }

-keep class * implements dora.db.table.OrmTable { *; }
-keep class * implements dora.db.converter.PropertyConverter { *; }

-keep class org.json.JSONObject { *; }
-keep class dora.trade.ModalDelegateProxy { *; }
-keep class com.walletconnect.web3.modal.client.Web3Modal { *; }
-keep class com.walletconnect.web3.modal.client.models.request.Request { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Params$Init { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$SessionRequestResponse { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$JsonRpcResponse$JsonRpcResult { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$JsonRpcResponse$JsonRpcError { *; }
-keep class com.walletconnect.android.Core$Model$AppMetaData { *; }
-keep class com.walletconnect.android.CoreClient { *; }
-keep class com.walletconnect.android.relay.ConnectionType { *; }
