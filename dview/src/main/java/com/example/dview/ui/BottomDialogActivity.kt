package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityBottomDialogBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraBottomMenuDialog

@Route(path = ARouterPath.ACTIVITY_BOTTOM_DIALOG)
class BottomDialogActivity : BaseActivity<ActivityBottomDialogBinding>() {

    private val dialog = DoraBottomMenuDialog()

    override fun getLayoutId(): Int {
        return R.layout.activity_bottom_dialog
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityBottomDialogBinding) {
        dialog.setOnMenuClickListener(object : DoraBottomMenuDialog.OnMenuClickListener {
            override fun onMenuClick(position: Int, menu: String) {
                showShortToast("点击了第${position+1}个菜单")
            }
        })
        binding.btnShowBottomDialog.setOnClickListener {
            // 打开底部菜单弹窗
            dialog.show(this, arrayOf("菜单1", "菜单2", "菜单3"))
        }
    }
}