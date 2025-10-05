package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityIconLabelBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_ICON_LABEL)
class IconLabelActivity : BaseActivity<ActivityIconLabelBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_icon_label
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityIconLabelBinding) {
        binding.ilv1.setOnClickListener {
            showShortToast("点击了柱状图菜单")
        }
        binding.ilv2.setOnClickListener {
            showShortToast("点击了折线图菜单")
        }
        binding.ilv3.setOnClickListener {
            showShortToast("点击了饼图菜单")
        }
    }
}