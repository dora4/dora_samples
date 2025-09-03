package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityEventBusBinding

@Deprecated("组件化示例不显示")
@Route(path = ARouterPath.ACTIVITY_EVENT_BUS)
class EventBusActivity : BaseActivity<ActivityEventBusBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_event_bus
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    fun onMessageEvent(msg: MessageEvent) {
//        when (msg.what) {
//            MessageEvent.EVENT_TEST_EVENT_BUS -> showShortToast("收到了测试的消息")
//        }
//    }

    fun sendEvent() {
//        EventBus.getDefault().post(MessageEvent(MessageEvent.EVENT_TEST_EVENT_BUS))
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityEventBusBinding) {
        binding.v = this
    }
}