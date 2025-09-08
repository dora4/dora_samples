package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivitySplashViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_SPLASH_VIEW)
class SplashViewActivity : BaseActivity<ActivitySplashViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivitySplashViewBinding) {
        binding.splashView.onCountdownFinish = {
            Toast.makeText(this, "倒计时完成，进入主界面", Toast.LENGTH_SHORT).show()
            // TODO: 跳转主页面
        }

        binding.splashView.onSkipClicked = {
            Toast.makeText(this, "用户点击跳过", Toast.LENGTH_SHORT).show()
            // TODO: 跳转主页面
        }

        binding.splashView.start()
    }
}