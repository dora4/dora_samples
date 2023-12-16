package com.example.dora

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.databinding.ActivityMenuListBinding
import com.example.dora.di.component.DaggerMenuComponent
import com.example.dora.vm.MenuViewModel
import dora.BaseVMActivity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseVMActivity<ActivityMenuListBinding, MenuViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMenuComponent.builder()
            .appComponent((application as SampleApp).appComponent)
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onBindViewModel(binding: ActivityMenuListBinding, viewModel: MenuViewModel) {
        super.onBindViewModel(binding, viewModel)
        binding.v = this
        binding.vm = viewModel
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}