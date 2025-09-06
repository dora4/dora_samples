package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityFlipperViewBinding
import dora.arouter.open
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraFlipperView

@Route(path = ARouterPath.ACTIVITY_FLIPPER_VIEW)
class FlipperViewActivity : BaseActivity<ActivityFlipperViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_flipper_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityFlipperViewBinding) {
        binding.flipperView.setFlipperListener(object : DoraFlipperView.FlipperListener {

            override fun onFlipFinish() {
            }

            override fun onFlipStart() {
            }

            override fun onItemClick(text: String) {
            }
        })
        binding.flipperView.addText("AAA")
        binding.flipperView.addText("BBB")
        binding.flipperView.addText("CCC")
    }
}