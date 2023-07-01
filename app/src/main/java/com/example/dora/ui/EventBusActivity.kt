package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.MessageEvent
import com.example.dora.databinding.ActivityEventBusBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_EVENT_BUS)
class EventBusActivity : BaseActivity<ActivityEventBusBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_event_bus
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
        when (msg.what) {
            MessageEvent.EVENT_TEST_EVENT_BUS -> showShortToast("收到了测试的消息")
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.btnSendEvent.setOnClickListener {
            EventBus.getDefault().post(MessageEvent(MessageEvent.EVENT_TEST_EVENT_BUS))
        }
    }
}