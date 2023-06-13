package com.example.dora.lifecycle

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import dora.lifecycle.application.ApplicationLifecycleCallbacks

class ARouterAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context?) {
    }

    override fun onCreate(application: Application?) {
        ARouter.init(application)
    }

    override fun onTerminate(application: Application?) {
    }
}