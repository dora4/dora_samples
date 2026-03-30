package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityViewModelSample3Binding
import com.example.dora.vm.ViewModelSample3ViewModel
import dora.BaseActivity
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import kotlinx.coroutines.launch

@Route(path = ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_3)
class ViewModelSample3Activity :
    BaseActivity<ActivityViewModelSample3Binding>() {

    private val viewModel by viewModels<ViewModelSample3ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_view_model_sample3
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityViewModelSample3Binding) {
        binding.vm = viewModel
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.textState.collect {
                    binding.tvText.text = it
                }
            }
        }
    }
}