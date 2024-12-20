package com.example.dora.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.MessageEvent
import dora.BaseVMActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityViewModelSample1Binding
import com.example.dora.vm.ViewModelSample1ViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 使用ObservableField。
 */
@Route(path = ARouterPath.ACTIVITY_VIEW_MODEL_SAMPLE_1)
class ViewModelSample1Activity :
    BaseVMActivity<ActivityViewModelSample1Binding, ViewModelSample1ViewModel>() {

    private val viewModel by viewModels<ViewModelSample1ViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.activity_view_model_sample1
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityViewModelSample1Binding) {
        super.initData(savedInstanceState, binding)
        binding.vm = viewModel
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}