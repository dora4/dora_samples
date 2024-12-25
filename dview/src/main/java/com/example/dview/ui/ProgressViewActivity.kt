package com.example.dview.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.common.MessageEvent
import com.example.dview.databinding.ActivityProgressViewBinding
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_PROGRESS_VIEW)
class ProgressViewActivity : BaseActivity<ActivityProgressViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_progress_view
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityProgressViewBinding) {
        binding.pv1.setPercentRate(1f)
        binding.pv2.setPercentRate(1f)
        binding.pv3.setPercentRate(1f)
        binding.pv4.setPercentRate(1f)
        binding.pv5.setPercentRate(1f)
        binding.pv6.setPercentRate(1f)
        binding.pv7.setPercentRate(1f)
        binding.pv8.setPercentRate(1f)
        binding.pv9.setPercentRate(1f)
        binding.pv10.setPercentRate(1f)
        binding.pv11.setPercentRate(1f)
        binding.pv12.setPercentRate(1f)
        binding.pv13.setPercentRate(1f)
        binding.pv14.setPercentRate(1f)
        binding.pv15.setPercentRate(1f)
        binding.pv16.setPercentRate(1f)
        binding.pv17.setPercentRate(1f)
        binding.pv18.setPercentRate(1f)
        binding.pv19.setPercentRate(1f)
        binding.pv20.setPercentRate(1f)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}