package com.example.dview.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityProgressBarBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_PROGRESS_BAR)
class ProgressBarActivity : BaseActivity<ActivityProgressBarBinding>() {

    var dialog: Dialog? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_progress_bar
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityProgressBarBinding) {
        binding.btnShowLoadingView.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }
        binding.btnHideLoadingView.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
        }
        binding.btnShowLoadingDialog.setOnClickListener {
            if (dialog == null) {
                dialog = Dialog(this, R.style.MyLoadingDialogStyle)
            }
            dialog!!.setContentView(R.layout.dialog_loading)
            dialog!!.setCancelable(false)
            dialog!!.show()
            Handler(Looper.getMainLooper()).postDelayed({
                dialog?.dismiss()
            }, 3000)
        }
    }
}