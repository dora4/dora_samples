package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityTipsBinding
import dora.BaseActivity
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ToastUtils

@Route(path = ARouterPath.ACTIVITY_TIPS)
class TipsActivity : BaseActivity<ActivityTipsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_tips
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTipsBinding) {
        binding.tvSummary.text = "由于Android系统限制无法在子线程更新界面，所以直接在子线程显示Toast会报错，" +
                "因此使用ToastUtils工具类将操作由子线程自动发送到主线程执行。"
        binding.btnTips01.setOnClickListener {
            ToastUtils.showShort("ToastUtils.showShort()")
        }
        binding.btnTips02.setOnClickListener {
            Thread {
                ToastUtils.showLong("ToastUtils.showLong()")
            }.start()
        }
    }
}