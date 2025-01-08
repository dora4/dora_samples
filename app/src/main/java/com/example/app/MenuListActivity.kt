package com.example.app

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.app.databinding.ActivityMenuListBinding
import com.example.app.di.component.DaggerMenuComponent
import com.example.app.vm.MenuViewModel
import com.example.common.ARouterPath
import dora.BaseVMActivity

@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseVMActivity<ActivityMenuListBinding, MenuViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 此处代码也可以在DaggerBaseActivity的回调中调用 https://github.com/dora4/dora-dagger-support
        DaggerMenuComponent.builder()
            .appComponent((application as SampleApp).appComponent)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    // 继承BaseVMActivity方式提供ViewModel，常用在只有一种ViewModel的场景
    override fun onBindViewModel(binding: ActivityMenuListBinding, viewModel: MenuViewModel) {
        super.onBindViewModel(binding, viewModel)
        binding.v = this
        binding.vm = viewModel
    }
}