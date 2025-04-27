package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import com.example.dora.R
import com.example.dora.databinding.ActivityViewModelSample1Binding
import com.example.dora.vm.ViewModelSample1ViewModel
import androidx.databinding.ObservableField
import dora.BaseActivity
import dora.util.IntentUtils
import dora.util.StatusBarUtils

/**
 * 使用[ObservableField]。
 */
@Route(path = ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_1)
class ViewModelSample1Activity :
    BaseActivity<ActivityViewModelSample1Binding>() {

    // 官方方式注入
    private val viewModel by viewModels<ViewModelSample1ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_view_model_sample1
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityViewModelSample1Binding) {
        super.initData(savedInstanceState, binding)
        binding.vm = viewModel
    }
}