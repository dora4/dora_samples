package com.example.app.vm

import com.example.common.adapter.MenuListAdapter
import com.example.common.vm.BaseViewModel

/**
 * 菜单列表，总的列表不会在子模块使用到，直接放到app模块。
 */
class MenuViewModel(menuListAdapter: MenuListAdapter) : BaseViewModel() {

    init {
        adapter.set(menuListAdapter)
    }
}