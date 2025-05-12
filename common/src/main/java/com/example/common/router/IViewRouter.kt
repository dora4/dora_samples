package com.example.common.router

import com.alibaba.android.arouter.facade.template.IProvider

interface IViewRouter : IProvider {

    fun showFloatingView()

    fun closeFloatingView()
}