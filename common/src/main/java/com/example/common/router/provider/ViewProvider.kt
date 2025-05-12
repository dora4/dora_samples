package com.example.common.router.provider

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.ARouterPath
import com.example.common.router.IViewRouter

object ViewProvider {

    @Autowired(name = ARouterPath.VIEW_SERVICE)
    lateinit var viewRouter: IViewRouter

    init {
        ARouter.getInstance().inject(this)
    }

    fun showFloatingView() {
        viewRouter.showFloatingView()
    }

    fun closeFloatingView() {
        viewRouter.closeFloatingView()
    }
}