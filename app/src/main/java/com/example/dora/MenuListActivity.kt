package com.example.dora

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.databinding.ActivityMenuListBinding
//import com.example.dora.di.component.DaggerMenuComponent
import com.example.dora.vm.VMMenu
import dora.BaseActivity
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseActivity<ActivityMenuListBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        DaggerMenuComponent.builder()
//            .appComponent((application as SampleApp).appComponent)
//            .build()
//            .inject(this)
        super.onCreate(savedInstanceState)
    }

    /**
     * 初始化数据的地方，在Activity的onCreate()之后调用。
     */
    override fun initData(savedInstanceState: Bundle?, binding: ActivityMenuListBinding) {
        binding.vm = ViewModelProvider(this)[VMMenu::class.java]
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}