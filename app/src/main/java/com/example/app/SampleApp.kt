package com.example.app

import com.alibaba.android.arouter.launcher.ARouter
import com.example.app.di.component.AppComponent
import com.example.app.di.component.DaggerAppComponent
import com.example.common.di.module.AppModule
import com.example.common.model.PopMusic
import com.example.common.service.MusicService
import com.example.dcache.model.OrmTestModel
import com.walletconnect.web3.modal.client.Modal
import com.walletconnect.web3.modal.presets.Web3ModalChainsPresets
import dora.BaseApplication
import dora.db.Orm
import dora.db.OrmConfig
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import dora.trade.DoraTrade

/**
 * 继承dora.BaseApplication开始Dora之旅吧！如果你不使用这个BaseApplication，直接开始继承
 * dora.BaseActivity也是可以的，这样做的话，会丢失Dora对于app开发的一些优化，如Dora SDK的生
 * 命周期注入将无法使用。
 */
class SampleApp : BaseApplication() {

    /**
     * Dagger组件化依赖注入可以根据实际业务选择取舍。
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
        ARouter.openLog()    // 打开日志
        ARouter.openDebug()  // 打开调试模式
    }

    private fun initPay() {
        // 通过chainId指定支持的以太坊兼容链
        val chains: Array<Modal.Model.Chain> = arrayOf(
            Web3ModalChainsPresets.ethChains["1"]!!,      // 支持Ethereum
            Web3ModalChainsPresets.ethChains["137"]!!,    // 支持Polygon
            Web3ModalChainsPresets.ethChains["42161"]!!,   // 支持Arbitrum
            Web3ModalChainsPresets.ethChains["43114"]!!    // 支持Avalanche C-Chain
        )
        DoraTrade.init(this, "App Name", "App Description", "https://yourdomain.com", chains)
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
            mappingBaseUrl(MusicService::class.java, "http://doramusic.site:8080/")
        }
    }

    private fun initOrm() {
        val config = OrmConfig.Builder()
            .database("dora_sample")
            .version(2)
            .tables(PopMusic::class.java, OrmTestModel::class.java)
            .build()
        Orm.init(this, config)
    }
}