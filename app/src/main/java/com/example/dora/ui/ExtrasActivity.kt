package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.bean.MessageEvent
import com.example.dora.databinding.ActivityExtrasBinding
import dora.BaseActivity
import dora.arouter.open
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_EXTRAS)
class ExtrasActivity : BaseActivity<ActivityExtrasBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_extras
    }

    override fun initData(savedInstanceState: Bundle?) {
        // 1. implementation 'com.alibaba:arouter-api:1.5.2'
        // annotationProcessor 'com.alibaba:arouter-compiler:1.5.2'
        // kapt 'com.alibaba:arouter-compiler:1.5.2'
        // 2. api 'com.github.dora4:dora-arouter-support:1.1'
        // 3. 在AndroidManifest.xml加入
        // <meta-data
        // android:name="dora.lifecycle.config.ARouterGlobalConfig"
        // android:value="GlobalConfig" />
        open(ARouterPath.ACTIVITY_WEB_VIEW) {
            withString("url", "https://github.com/dora4");
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}