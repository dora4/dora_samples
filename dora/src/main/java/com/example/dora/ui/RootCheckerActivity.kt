package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityRootCheckerBinding
import dora.security.RootChecker
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_ROOT_CHECKER)
class RootCheckerActivity : BaseActivity<ActivityRootCheckerBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_root_checker
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityRootCheckerBinding) {
        binding.btnCheckRoot.setOnClickListener {
            showShortToast("ROOT检测：${if (RootChecker(this).isRooted) "已ROOT" else "未ROOT" }")
        }
    }
}