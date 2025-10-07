package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityExpandableLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_EXPANDABLE_LAYOUT)
class ExpandableLayoutActivity : BaseActivity<ActivityExpandableLayoutBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_expandable_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityExpandableLayoutBinding) {
        val content1 = LayoutInflater.from(this).inflate(R.layout.layout_expandable_layout, null)
        val content2 = LayoutInflater.from(this).inflate(R.layout.layout_expandable_layout, null)
        binding.expandable1.setContent(content1)
        binding.expandable2.setContent(content2)
        binding.expandable1.onToggle = { expanded ->
            println("第一个展开状态：$expanded")
        }
        binding.expandable2.onToggle = { expanded ->
            println("第二个展开状态：$expanded")
        }
    }
}