package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityNetDetectBinding
import dora.util.IntentUtils
import dora.util.NetUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_NET_DETECT)
class NetDetectActivity : BaseActivity<ActivityNetDetectBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_net_detect
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityNetDetectBinding) {
        if (NetUtils.checkNetworkAvailable(this)) {
            if (NetUtils.isWifiConnected(this)) {
                binding.tvNetStatus.text = "网络已连接[无线网络]"
            } else if (NetUtils.isMobileConnected(this)) {
                binding.tvNetStatus.text = "网络已连接[移动网络]"
            }
        } else {
            binding.tvNetStatus.text = "网络连接已断开"
        }
    }

    override fun isDetectNet(): Boolean {
        return true
    }

    override fun onNetworkConnected(type: NetUtils.ApnType) {
        if (NetUtils.isWifiConnected(this)) {
            mBinding.tvNetStatus.text = "网络已连接[无线网络]"
        } else if (NetUtils.isMobileConnected(this)) {
            mBinding.tvNetStatus.text = "网络已连接[移动网络]"
        }
    }

    override fun onNetworkDisconnected() {
        mBinding.tvNetStatus.text = "网络连接已断开"
    }
}