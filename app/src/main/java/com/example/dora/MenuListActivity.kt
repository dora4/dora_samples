package com.example.dora

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.databinding.ActivityMenuListBinding
import com.example.dora.di.component.DaggerMenuComponent
import com.example.dora.vm.MenuViewModel
import dora.BaseVMActivity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 所有菜单请查看[MenuViewModel].
 */
@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseVMActivity<ActivityMenuListBinding, MenuViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 此处代码也可以在DaggerBaseActivity的回调方法中调用 https://github.com/dora4/dora-dagger-support
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}