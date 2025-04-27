package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dview.R
import com.example.dview.databinding.ActivityToastBinding
import dora.BaseActivity
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.Tips

@Route(path = ARouterPath.ACTIVITY_TOAST)
class ToastActivity : BaseActivity<ActivityToastBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_toast
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityToastBinding) {
        binding.btnShow.setOnClickListener {
            Tips.show("这是常规Toast")
        }
        binding.btnShowSuccess.setOnClickListener {
            Tips.showSuccess("这是成功Toast")
        }
        binding.btnShowFailure.setOnClickListener {
            Tips.showWarning("这是失败Toast")
        }
    }
}