package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.MessageEvent

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityNetDetectBinding
import dora.util.NetUtils
import dora.util.ToastUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_NET_DETECT)
class NetDetectActivity : BaseActivity<ActivityNetDetectBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_net_detect
    }

    override fun initData(savedInstanceState: Bundle?) {
        if (NetUtils.checkNetworkAvailable(this)) {
            if (NetUtils.isWifiConnected(this)) {
                mBinding.tvNetStatus.text = "网络已连接[无线网络]"
            } else if (NetUtils.isMobileConnected(this)) {
                mBinding.tvNetStatus.text = "网络已连接[移动网络]"
            }
        } else {
            mBinding.tvNetStatus.text = "网络连接已断开"
        }
    }

    override fun onNetworkConnected(type: NetUtils.ApnType) {
        super.onNetworkConnected(type)
        if (NetUtils.isWifiConnected(this)) {
            mBinding.tvNetStatus.text = "网络已连接[无线网络]"
        } else if (NetUtils.isMobileConnected(this)) {
            mBinding.tvNetStatus.text = "网络已连接[移动网络]"
        }
    }

    override fun onNetworkDisconnected() {
        super.onNetworkDisconnected()
        mBinding.tvNetStatus.text = "网络连接已断开"
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}