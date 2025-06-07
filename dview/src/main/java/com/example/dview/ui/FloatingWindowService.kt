package com.example.dview.ui

import com.example.dview.R
import dora.BaseFloatingWindowService
import dora.util.DensityUtils
import dora.util.ScreenUtils
import dora.util.ToastUtils
import dora.widget.DoraFloatingMenuView

class FloatingWindowService : BaseFloatingWindowService() {

    override fun getLayoutId(): Int {
        return R.layout.layout_floating_view
    }

    override fun getInitialPosition(): IntArray {
        return intArrayOf(ScreenUtils.getScreenWidth() - DensityUtils.DP200,
            ScreenUtils.getScreenHeight() - DensityUtils.DP200)
    }

    override fun initViews() {
        val menuView = findViewById<DoraFloatingMenuView>(R.id.floating_view)
        menuView.onSectorClick = { index ->
            ToastUtils.showShort("点击了扇形按钮 ${index+1}")
        }
        menuView.onCenterClick = {
            ToastUtils.showShort("点击了中心按钮")
        }
    }
}