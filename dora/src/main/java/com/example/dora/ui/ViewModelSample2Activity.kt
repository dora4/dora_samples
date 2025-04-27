package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import com.example.dora.R
import com.example.dora.databinding.ActivityViewModelSample2Binding
import com.example.dora.vm.ViewModelSample2ViewModel
import dora.BaseActivity
import dora.util.IntentUtils
import dora.util.StatusBarUtils

/**
 * 使用[LiveData]。
 */
@Route(path = ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_2)
class ViewModelSample2Activity :
    BaseActivity<ActivityViewModelSample2Binding>() {

    // 官方方式注入
    private val viewModel by viewModels<ViewModelSample2ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_view_model_sample2
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityViewModelSample2Binding) {
        super.initData(savedInstanceState, binding)
        binding.vm = viewModel
        // 确保与数据绑定的LiveData正确连接到生命周期
        binding.lifecycleOwner = this
        viewModel.liveData.observe(this) {
            binding.tvText.text = it
        }
    }
}