package com.example.app

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.app.databinding.ActivityMenuListBinding
import com.example.app.di.component.DaggerMenuComponent
import com.example.app.vm.MenuViewModel
import com.example.common.ARouterPath
import com.example.common.adapter.MenuListAdapter
import com.example.common.di.module.MenuModule
import dora.BaseVMActivity
import javax.inject.Inject

/**
 * 所有菜单请查看[MenuViewModel].
 */
@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseVMActivity<ActivityMenuListBinding, MenuViewModel>() {

    @Inject lateinit var adapter: MenuListAdapter
    private lateinit var viewModel: MenuViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 此处代码也可以在DaggerBaseActivity的回调方法中调用 https://github.com/dora4/dora-dagger-support
        val menuModule = MenuModule()
        DaggerMenuComponent.builder()
            .appComponent((application as SampleApp).appComponent)
            .menuModule(menuModule)
            .build()
            .inject(this)
        val factory = MenuViewModelFactory(adapter)
        viewModel = ViewModelProvider(this, factory)[MenuViewModel::class.java]
        super.onCreate(savedInstanceState)
    }

    class MenuViewModelFactory(
        private val adapter: MenuListAdapter
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
                return MenuViewModel(adapter) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    // 继承BaseVMActivity方式提供ViewModel，常用在只有一种ViewModel的场景
    override fun onBindViewModel(binding: ActivityMenuListBinding, viewModel: MenuViewModel) {
        super.onBindViewModel(binding, viewModel)
        binding.v = this
        binding.vm = viewModel
    }
}