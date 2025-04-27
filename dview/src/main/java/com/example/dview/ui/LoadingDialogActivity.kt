package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.databinding.ActivityLoadingDialogBinding
import com.example.dview.R
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraLoadingDialog

@Route(path = ARouterPath.ACTIVITY_LOADING_DIALOG)
class LoadingDialogActivity : BaseActivity<ActivityLoadingDialogBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_loading_dialog
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityLoadingDialogBinding) {
        binding.btnShowLoadingDialog.setOnClickListener {
            val dialog = DoraLoadingDialog(this).show("登录中...") {
                messageTextSize(15f)
            }
            binding.root.postDelayed({ dialog.dismissWithAnimation() }, 1000)
        }
    }
}