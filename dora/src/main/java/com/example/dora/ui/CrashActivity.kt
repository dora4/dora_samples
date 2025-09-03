package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityCrashBinding
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import dora.BaseActivity
import dora.crash.DoraCrash
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_CRASH)
class CrashActivity : BaseActivity<ActivityCrashBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_crash
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    fun requestPermission() {
        XXPermissions.with(this)
            .permission(Permission.MANAGE_EXTERNAL_STORAGE)
            .request { permissions, allGranted ->
                DoraCrash.initCrash(this, "crash")
            }
    }

    fun makeBug() {
        throw RuntimeException("这是一个玩笑的BUG😁")
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCrashBinding) {
        binding.v = this
    }
}