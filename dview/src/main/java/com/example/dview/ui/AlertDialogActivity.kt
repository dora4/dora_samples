package com.example.dview.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.databinding.ActivityAlertDialogBinding
import com.example.dview.R
import dora.widget.DoraAlertDialog

@Route(path = ARouterPath.ACTIVITY_ALERT_DIALOG)
class AlertDialogActivity : BaseActivity<ActivityAlertDialogBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_alert_dialog
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityAlertDialogBinding) {
        binding.btnShowAlertDialog.setOnClickListener {
            DoraAlertDialog(this).show("提示信息") {
                title("系统消息")
                themeColorResId(com.example.common.R.color.colorAccent)
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