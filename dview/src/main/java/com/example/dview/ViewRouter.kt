package com.example.dview

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.common.router.IViewRouter

@Route(path = ARouterPath.VIEW_SERVICE)
class ViewRouter : IViewRouter {

    private lateinit var context: Context

    override fun init(context: Context) {
        this.context = context
    }

    override fun showFloatingView() {
        if (Settings.canDrawOverlays(context)) {
            context.startService(Intent(context, FloatingWindowService::class.java))
        }
    }

    override fun closeFloatingView() {
        context.stopService(Intent(context, FloatingWindowService::class.java))
    }
}