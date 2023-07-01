package com.example.dora

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.bean.Menu
import com.example.dora.databinding.ActivityMenuListBinding
import com.example.dora.di.component.DaggerMenuComponent
import com.example.dora.model.MenuModel
import dora.BaseActivity
import dora.arouter.open
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseActivity<ActivityMenuListBinding>() {

    /**
     * 注入菜单列表。
     */
    @Inject
    lateinit var model: MenuModel

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

    /**
     * 初始化数据的地方，在Activity的onCreate()之后调用。
     */
    override fun initData(savedInstanceState: Bundle?) {
        mBinding.rvMenuList.layoutManager = LinearLayoutManager(this)
        mBinding.rvMenuList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val adapter = MenuListAdapter(model.loadMenus())
        adapter.setOnItemClickListener { adapter, view, position -> open((adapter.getItem(position) as Menu).path) }
        mBinding.rvMenuList.adapter = adapter
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}