package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityProgressButtonBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.ProgressButton

@Route(path = ARouterPath.ACTIVITY_PROGRESS_BUTTON)
class ProgressButtonActivity : BaseActivity<ActivityProgressButtonBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_progress_button
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityProgressButtonBinding) {
        // 点击按钮开始模拟进度
        binding.progressButton.setOnClickListener {
            if (binding.progressButton.isNew()) {
                binding.progressButton.mockProgress()
            } else if (binding.progressButton.isPause()) {
                binding.progressButton.mockProgress()
            }
        }
        // 设置监听器
        binding.progressButton.setOnProgressChangeListener(object : ProgressButton.OnProgressChangeListener {
            override fun onPause() {
                Toast.makeText(this@ProgressButtonActivity, "进度已暂停", Toast.LENGTH_SHORT).show()
            }

            override fun onPendingProgress(progress: Float) {
                // 这里可以更新 UI 或日志
                Log.d("ProgressButton", "当前进度: $progress")
            }

            override fun onFinish() {
                Toast.makeText(this@ProgressButtonActivity, "任务完成", Toast.LENGTH_SHORT).show()
            }
        })
    }
}