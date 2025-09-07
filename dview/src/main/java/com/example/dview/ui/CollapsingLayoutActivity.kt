package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityCollapsingLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraCollapsingLayout

@Route(path = ARouterPath.ACTIVITY_COLLAPSING_LAYOUT)
class CollapsingLayoutActivity : BaseActivity<ActivityCollapsingLayoutBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_collapsing_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCollapsingLayoutBinding) {
        setSupportActionBar(binding.toolbar)
        binding.collapsingLayout.setOnScrimsListener(object : DoraCollapsingLayout.OnScrimsListener {
            override fun onScrimsStateChange(layout: DoraCollapsingLayout, shown: Boolean) {
                if (shown) {
                    Toast.makeText(this@CollapsingLayoutActivity, "Scrims 显示", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@CollapsingLayoutActivity, "Scrims 隐藏", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}