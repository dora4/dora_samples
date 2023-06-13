package com.example.dora.lifecycle

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentManager
import dora.lifecycle.application.ApplicationLifecycleCallbacks
import dora.lifecycle.config.GlobalConfig

/**
 * ARouter的初始化的封装。追加GlobalConfig配置，只要使用了com.lwh.dora.BaseApplication，就会加载默认配
 * 置DefaultGlobalConfig，用于打印生命周期的日志。GlobalConfig可以配置多个哦！同样的，需要GlobalConfig生效，
 * 需要在AndroidManifest.xml中的application标签配置com.lwh.dora.BaseApplication。
 */
class ARouterGlobalConfig : GlobalConfig {

    override fun injectApplicationLifecycle(
        context: Context?,
        lifecycles: MutableList<ApplicationLifecycleCallbacks>?
    ) {
        lifecycles!!.add(ARouterAppLifecycle())
    }

    override fun injectFragmentLifecycle(
        context: Context?,
        lifecycles: MutableList<FragmentManager.FragmentLifecycleCallbacks>?
    ) {
    }

    override fun injectActivityLifecycle(
        context: Context?,
        lifecycles: MutableList<Application.ActivityLifecycleCallbacks>?
    ) {
        lifecycles!!.add(ARouterActivityLifecycle())
    }
}