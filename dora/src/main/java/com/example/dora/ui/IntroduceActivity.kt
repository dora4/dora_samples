package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.common.MessageEvent
import com.example.dora.databinding.ActivityIntroduceBinding
import dora.BaseActivity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_INTRODUCE)
class IntroduceActivity : BaseActivity<ActivityIntroduceBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_introduce
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityIntroduceBinding) {
        binding.introduce = "Android开发全家桶框架，https://github.com/dora4/dora。 Dora支持Java和" +
                "Kotlin语言的Android开发，致力于帮助你打造一款高质量的Android App。"
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}