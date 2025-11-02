package com.example.dora.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.common.router.provider.ViewProvider

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityRouteBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_ROUTE)
class RouteActivity : BaseActivity<ActivityRouteBinding>() {

    companion object {
        const val REQUEST_OVERLAY_PERMISSION = 0
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_route
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_OVERLAY_PERMISSION) {
                ViewProvider.showFloatingView()
            }
        }
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityRouteBinding) {
        binding.tvSummary.text = "在ARouter中调用其它组件的功能，可使用悬浮球作为其他组件功能的入口。"
        binding.btnShowFloatingView.setOnClickListener {
            if (!IntentUtils.hasOverlayPermission(this)) {
                startActivityForResult(IntentUtils.getRequestOverlayPermissionIntent(packageName), REQUEST_OVERLAY_PERMISSION)
            } else {
                ViewProvider.showFloatingView()
            }
        }
        binding.btnCloseFloatingView.setOnClickListener {
            ViewProvider.closeFloatingView()
        }
    }
}