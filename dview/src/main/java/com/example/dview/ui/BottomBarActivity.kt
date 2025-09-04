package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityBottomBarBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraBottomBar

@Route(path = ARouterPath.ACTIVITY_BOTTOM_BAR)
class BottomBarActivity : BaseActivity<ActivityBottomBarBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_bottom_bar
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityBottomBarBinding) {
        binding.bottomBar.setOnTabSelectedListener(object : DoraBottomBar.OnTabSelectedListener {
            override fun onTabSelected(index: Int) {
                when (index) {
                    0 -> {
                        showShortToast("切换到Tab1")
                    }
                    1 -> {
                        showShortToast("切换到Tab2")
                    }
                }
            }
        })
    }
}