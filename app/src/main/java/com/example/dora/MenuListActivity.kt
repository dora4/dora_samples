package com.example.dora

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.databinding.ActivityMenuListBinding
import com.example.dora.di.component.DaggerMenuComponent
import com.example.dora.model.MenuModel
import dora.BaseActivity
import kotlinx.android.synthetic.main.activity_menu_list.*
import javax.inject.Inject

/**
 * 从菜单开始了解Dora，可以更快的了解我哦。
 */
@Route(path = ARouterPath.ACTIVITY_MENU_LIST)
class MenuListActivity : BaseActivity<ActivityMenuListBinding>() {

    /**
     * 注入菜单列表。
     */
    @Inject
    lateinit var model: MenuModel

    /**
     * 告诉系统布局在什么地方。
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_menu_list
    }

    override fun onSetupComponent() {
        DaggerMenuComponent.builder()
            .appComponent((application as SampleApp).appComponent)
            .build()
            .inject(this)
    }

    /**
     * 初始化数据的地方，在Activity的onCreate()之后调用。
     */
    override fun initData(savedInstanceState: Bundle?) {
        rv_menu_list.layoutManager = LinearLayoutManager(this)
        rv_menu_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val adapter = MenuListAdapter(model.loadMenus())
        adapter.setOnItemClickListener { _, _, _, position -> open(adapter.items[position].path) }
        rv_menu_list.adapter = adapter
    }
}