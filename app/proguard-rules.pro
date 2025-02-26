-keepattributes *Annotation*

# ARouter
-keep class com.alibaba.android.arouter.** { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.IRouteGroup { *; }
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider { *; }
-keepclasseswithmembernames class * {
    @Autowired <fields>;
}

# Javax Element (用于 ARouter)
-keep class javax.lang.model.element.** { *; }

# Alipay SDK
-keep class com.alipay.sdk.** { *; }

# Just AgentWeb
-keep class com.just.agentweb.** { *; }

# Download Library
-keep class com.download.library.** { *; }

# SLF4J Logger
-keep class org.slf4j.** { *; }
-keep class org.slf4j.impl.** { *; }

