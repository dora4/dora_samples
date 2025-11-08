package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.databinding.ActivityAlertDialogBinding
import com.example.dview.R
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraAlertDialog

@Route(path = ARouterPath.ACTIVITY_ALERT_DIALOG)
class AlertDialogActivity : BaseActivity<ActivityAlertDialogBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_alert_dialog
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityAlertDialogBinding) {
        binding.btnShowAlertDialog.setOnClickListener {
            DoraAlertDialog.create(this).show("提示信息") {
                title("系统消息")
                themeColorResId(com.example.common.R.color.sky_blue)
                positiveListener {
                    showShortToast("点击了确认按钮")
                }
                negativeListener {
                    showShortToast("点击了取消按钮")
                }
            }
        }
    }
}