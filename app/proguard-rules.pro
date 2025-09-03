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
-keep class dora.BaseVMActivity { *; }
-keep class dora.BaseVMFragment { *; }

-keep class * implements dora.db.table.OrmTable { *; }
-keep class * implements dora.db.converter.PropertyConverter { *; }

-keep class org.json.JSONObject { *; }
-keep class dora.pay.DoraFund { *; }
-keep class dora.pay.DoraFund$PayListener { *; }
-keep class org.web3j.** { *; }
-keep class com.walletconnect.web3.modal.client.Web3Modal { *; }
-keep class com.walletconnect.web3.modal.client.models.request.Request { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Params$Init { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$SessionRequestResponse { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$JsonRpcResponse$JsonRpcResult { *; }
-keep class com.walletconnect.web3.modal.client.Modal$Model$JsonRpcResponse$JsonRpcError { *; }
-keep class com.walletconnect.android.Core$Model$AppMetaData { *; }
-keep class com.walletconnect.android.CoreClient { *; }
-keep class com.walletconnect.android.relay.ConnectionType { *; }

-dontwarn afu.org.checkerframework.dataflow.qual.Pure
-dontwarn afu.org.checkerframework.dataflow.qual.SideEffectFree
-dontwarn afu.org.checkerframework.framework.qual.EnsuresQualifierIf
-dontwarn afu.org.checkerframework.framework.qual.EnsuresQualifiersIf
-dontwarn build.IgnoreJava8API
-dontwarn com.google.api.client.http.GenericUrl
-dontwarn com.google.api.client.http.HttpHeaders
-dontwarn com.google.api.client.http.HttpRequest
-dontwarn com.google.api.client.http.HttpRequestFactory
-dontwarn com.google.api.client.http.HttpResponse
-dontwarn com.google.api.client.http.HttpTransport
-dontwarn com.google.api.client.http.javanet.NetHttpTransport$Builder
-dontwarn com.google.api.client.http.javanet.NetHttpTransport
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ConversionCategory
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter.qual.ReturnsFormat
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.nullness.qual.EnsuresNonNull
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.regex.qual.Regex
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.formatter.qual.ConversionCategory
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.formatter.qual.ReturnsFormat
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.qual.EnsuresNonNull
-dontwarn com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.regex.qual.Regex
-dontwarn java.lang.management.ManagementFactory
-dontwarn java.lang.management.RuntimeMXBean
-dontwarn java.lang.management.ThreadMXBean
-dontwarn javax.naming.InvalidNameException
-dontwarn javax.naming.NamingEnumeration
-dontwarn javax.naming.NamingException
-dontwarn javax.naming.directory.Attribute
-dontwarn javax.naming.directory.Attributes
-dontwarn javax.naming.directory.DirContext
-dontwarn javax.naming.directory.InitialDirContext
-dontwarn javax.naming.directory.SearchControls
-dontwarn javax.naming.directory.SearchResult
-dontwarn javax.naming.ldap.LdapName
-dontwarn javax.naming.ldap.Rdn
-dontwarn javax.servlet.ServletContextEvent
-dontwarn javax.servlet.ServletContextListener
-dontwarn org.apache.avalon.framework.logger.Logger
-dontwarn org.apache.log.Hierarchy
-dontwarn org.apache.log.Logger
-dontwarn org.apache.log4j.Level
-dontwarn org.apache.log4j.Logger
-dontwarn org.apache.log4j.Priority
-dontwarn org.ietf.jgss.GSSContext
-dontwarn org.ietf.jgss.GSSCredential
-dontwarn org.ietf.jgss.GSSException
-dontwarn org.ietf.jgss.GSSManager
-dontwarn org.ietf.jgss.GSSName
-dontwarn org.ietf.jgss.Oid
-dontwarn org.joda.time.Instant