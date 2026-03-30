package com.example.dora.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityViewModelSample4Binding
import com.example.dora.vm.UiEvent
import com.example.dora.vm.ViewModelSample4ViewModel
import dora.BaseActivity
import kotlinx.coroutines.launch

@Route(path = ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_4)
class ViewModelSample4Activity :
    BaseActivity<ActivityViewModelSample4Binding>() {

    private val viewModel by viewModels<ViewModelSample4ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_view_model_sample4
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityViewModelSample4Binding) {
        binding.vm = viewModel
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventFlow.collect { event ->
                    when (event) {
                        is UiEvent.UpdateText -> {
                            binding.tvText.text = event.text
                        }
                    }
                }
            }
        }
    }
}