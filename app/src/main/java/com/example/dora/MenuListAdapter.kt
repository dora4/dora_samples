package com.example.dora

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.dora.bean.Menu

/**
 * 继承JKAdapter可以实现item的数据加载。
 */
class MenuListAdapter(menus: MutableList<Menu>) : BaseQuickAdapter<Menu, BaseViewHolder>(
    R.layout.item_menu_list, menus) {

    fun getLayoutId(viewType: Int): Int {
        return R.layout.item_menu_list
    }

    override fun convert(holder: BaseViewHolder, item: Menu) {
        holder.setText(R.id.tv_menu_item_id, "${getItemPosition(item) + 1}")
        holder.setTextColor(R.id.tv_menu_item_id, item.color)
        holder.setText(R.id.tv_menu_item_title, item.title)
        holder.setTextColor(R.id.tv_menu_item_title, item.color)
    }
}