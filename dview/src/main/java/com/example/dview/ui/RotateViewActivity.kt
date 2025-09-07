package com.example.dview.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityRotateViewBinding

@Route(path = ARouterPath.ACTIVITY_ROTATE_VIEW)
class RotateViewActivity : BaseActivity<ActivityRotateViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_rotate_view
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityRotateViewBinding) {
        binding.rotateView.startRotateAnimation()
    }

    override fun onDestroy() {
        mBinding.rotateView.cancelRotateAnimation()
        super.onDestroy()
    }
}