package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.common.MessageEvent
import com.example.dora.R
import com.example.dora.databinding.ActivityCrashBinding
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import dora.BaseActivity
import dora.crash.DoraCrash
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_CRASH)
class CrashActivity : BaseActivity<ActivityCrashBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_crash
    }

    fun makeBug() {
        // 除数不能为0
        val divideZero = 1 / 0
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCrashBinding) {
        binding.v = this
        XXPermissions.with(this)
            .permission(Permission.MANAGE_EXTERNAL_STORAGE)
            .request { permissions, allGranted ->
                DoraCrash.initCrash(this, "crash")
            }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}