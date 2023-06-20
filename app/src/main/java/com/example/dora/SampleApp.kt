package com.example.dora

import com.example.dora.di.component.AppComponent
import com.example.dora.di.component.DaggerAppComponent
import com.example.dora.di.module.AppModule
import com.example.dora.datacache.model.PopMusic
import com.example.dora.datacache.service.MusicService
import dora.BaseApplication
import dora.db.Orm
import dora.db.OrmConfig
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager

/**
 * 继承dora.BaseApplication开始Dora之旅吧！如果你不使用这个BaseApplication，直接开始继承
 * dora.BaseActivity也是可以的，这样做的话，会丢失Dora对于app开发的一些优化。
 */
class SampleApp : BaseApplication() {

    /**
     * Dagger组件化依赖注入可以根据实际业务选择取舍。
     */
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // 初始化dagger的app模块，dagger不是必须的
        val appModule = AppModule(this)
        appComponent = DaggerAppComponent.builder().appModule(appModule).build()
        appComponent.inject(this)
        // 初始化orm框架
        val config = OrmConfig.Builder()
            .database("dora_sample")
            .version(1)
            .tables(PopMusic::class.java)
            .build()
        Orm.init(this, config)
        // 初始化retrofit的配置
        RetrofitManager.initConfig {
            okhttp {
                // 添加格式化输出日志的拦截器
                interceptors().add(FormatLogInterceptor())
                build()
            }
            // 映射API服务地址
            mappingBaseUrl(MusicService::class.java, "http://doramusic.site:8080/")
        }
    }
}