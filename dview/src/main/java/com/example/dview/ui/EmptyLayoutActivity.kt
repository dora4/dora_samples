package com.example.dview.ui

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityEmptyLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_EMPTY_LAYOUT)
class EmptyLayoutActivity : BaseActivity<ActivityEmptyLayoutBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_empty_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityEmptyLayoutBinding) {
        binding.emptyLayout.apply {
            onLoading {
                ((this as ImageView).drawable as AnimationDrawable).start()
            }
            onError {
                val tvError = findViewById<TextView>(R.id.tv_common_error)
                tvError.text = it.message
            }
        }
        binding.btnShowContent.setOnClickListener {
            binding.emptyLayout.showContent()
        }
        binding.btnShowLoading.setOnClickListener {
            binding.emptyLayout.showLoading()
        }
        binding.btnShowError.setOnClickListener {
            binding.emptyLayout.showError(Exception("无网络连接"))
        }
        binding.btnShowEmpty.setOnClickListener {
            binding.emptyLayout.showEmpty()
        }
    }
}