package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.bean.MessageEvent
import com.example.dora.databinding.ActivityProgressViewBinding
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_PROGRESS_VIEW)
class ProgressViewActivity : BaseActivity<ActivityProgressViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_progress_view
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.pv1.setPercentRate(1f)
        mBinding.pv2.setPercentRate(1f)
        mBinding.pv3.setPercentRate(1f)
        mBinding.pv4.setPercentRate(1f)
        mBinding.pv5.setPercentRate(1f)
        mBinding.pv6.setPercentRate(1f)
        mBinding.pv7.setPercentRate(1f)
        mBinding.pv8.setPercentRate(1f)
        mBinding.pv9.setPercentRate(1f)
        mBinding.pv10.setPercentRate(1f)
        mBinding.pv11.setPercentRate(1f)
        mBinding.pv12.setPercentRate(1f)
        mBinding.pv13.setPercentRate(1f)
        mBinding.pv14.setPercentRate(1f)
        mBinding.pv15.setPercentRate(1f)
        mBinding.pv16.setPercentRate(1f)
        mBinding.pv17.setPercentRate(1f)
        mBinding.pv18.setPercentRate(1f)
        mBinding.pv19.setPercentRate(1f)
        mBinding.pv20.setPercentRate(1f)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}