package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityTipsBinding
import dora.BaseActivity
import dora.util.ToastUtils

@Route(path = ARouterPath.ACTIVITY_TIPS)
class TipsActivity : BaseActivity<ActivityTipsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_tips
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTipsBinding) {
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