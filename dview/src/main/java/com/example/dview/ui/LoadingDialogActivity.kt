package com.example.dview.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.common.MessageEvent
import com.example.dview.databinding.ActivityLoadingDialogBinding
import com.example.dview.R
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
        binding.root.postDelayed({ dialog.dismissWithAnimation() }, 1000)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}