package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivitySwipeMenuBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_SWIPE_MENU)
class SwipeMenuActivity : BaseActivity<ActivitySwipeMenuBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_swipe_menu
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivitySwipeMenuBinding) {
        binding.rlContent.setOnClickListener {
            showShortToast("点击了条目内容")
        }
        binding.btnDelete.setOnClickListener {
            showShortToast("点击了删除按钮")
        }
    }
}