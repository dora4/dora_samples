package com.example.dora.ui

import android.os.Bundle
import android.os.Handler
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.MessageEvent
import com.example.dora.databinding.ActivityLoadingDialogBinding
import dora.widget.DoraLoadingDialog
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_LOADING_DIALOG)
class LoadingDialogActivity : BaseActivity<ActivityLoadingDialogBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_loading_dialog
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityLoadingDialogBinding) {
        val dialog = DoraLoadingDialog(this).show("登录中...") {
            messageTextSize(15f)
        }
        Handler().postDelayed({
            dialog.dismissWithAnimation()
        }, 1000)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}