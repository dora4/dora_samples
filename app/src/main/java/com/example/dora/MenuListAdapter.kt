package com.example.dora

import android.view.View
import com.example.dora.bean.Menu
import com.example.dora.databinding.ItemMenuListBinding
import dora.adapter.BaseAdapter
import dora.adapter.ViewHolder

/**
 * 继承JKAdapter可以实现item的数据加载。
 */
class MenuListAdapter(menus: MutableList<Menu>) : BaseAdapter<Menu, ItemMenuListBinding>(menus) {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_menu_list
    }

    class MenuListViewHolder(itemView: View?) : ViewHolder<Menu, ItemMenuListBinding>(itemView) {

        override fun setData(binding: ItemMenuListBinding, data: Menu, position: Int) {
            binding.menu = data
            binding.tvMenuItemId.text = (position + 1).toString()
        }
    }

    override fun getHolder(v: View, viewType: Int): ViewHolder<Menu, ItemMenuListBinding> {
        return MenuListViewHolder(v)
    }
}