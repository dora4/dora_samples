package com.example.app

import com.alibaba.android.arouter.launcher.ARouter
import com.example.app.di.component.AppComponent
import com.example.app.di.component.DaggerAppComponent
import com.example.common.di.module.AppModule
import com.example.dcache.api.TestService
import com.example.dcache.db.model.OrmTestModel
import com.example.dcache.db.model.TestCaseModel
import com.example.dcache.db.model.TestCaseModel2
import com.example.dcache.db.model.TestCaseModel3
import com.example.dcache.db.model.TestCaseModel4
import dora.BaseApplication
import dora.db.Orm
import dora.db.OrmConfig
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import dora.pgyer.PgyService
import dora.pay.DoraFund
import dora.pay.EVMChains
import dora.util.ThreadUtils

/**
 * 继承[dora.BaseApplication]开始Dora之旅吧！如果你不使用这个[dora.BaseApplication]，直接开始继承
 * [dora.BaseActivity]也是可以的。这样做的话，会丢失Dora对于app开发的一些优化，如Dora SDK的生
 * 命周期注入将无法使用。
 */
class SampleApp : BaseApplication() {

    /**
     * Dagger组件化依赖注入可以根据实际业务规模选择取舍，用于大项目。
     */
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // 初始化dagger的app模块，dagger不是必须的
        initDagger()
        // 初始化orm框架
        initOrm()
        // 初始化retrofit的配置
        initRetrofit()
        // 初始化支付SDK
        initPay()
        // 懒加载，主线程空闲时执行一些不紧急的操作，不影响启动速度
        ThreadUtils.lazyLoad {
            ARouter.openLog()    // 打开日志
            ARouter.openDebug()  // 打开调试模式
            true
        }
    }

    private fun initPay() {
        DoraFund.init(this,
            "App Name", // 不会校验，仅显示在钱包
            "App Description", // 不会校验，仅显示在钱包
            "https://yourdomain.com", // 不会校验，仅显示在钱包
            arrayOf(
                EVMChains.ETHEREUM,   // 支持Ethereum
                EVMChains.POLYGON,    // 支持Polygon
                EVMChains.ARBITRUM,   // 支持Arbitrum
                EVMChains.AVALANCHE   // 支持Avalanche C-Chain
            )
        )
    }

    private fun initDagger() {
        val appModule = AppModule(this)
        appComponent = DaggerAppComponent.builder().appModule(appModule).build()
        appComponent.inject(this)
    }

    private fun initRetrofit() {
        RetrofitManager.initConfig {
            okhttp {
                // 添加格式化输出日志的拦截器
                interceptors().add(FormatLogInterceptor())
                build()
            }
            // 映射API服务地址，可以映射多个
            mappingBaseUrl(TestService::class.java, "http://dorachat.com:9091/")
            mappingBaseUrl(PgyService::class.java, "http://www.pgyer.com/apiv2/")
        }
    }

    private fun initOrm() {
        val config = OrmConfig.Builder()
            .database("dora_sample")
            .version(4) // 从1开始递增
            .tables(
                OrmTestModel::class.java,
                TestCaseModel::class.java,
                TestCaseModel2::class.java,
                TestCaseModel3::class.java,
                TestCaseModel4::class.java)
            .build()
        Orm.init(this, config)
    }
}
