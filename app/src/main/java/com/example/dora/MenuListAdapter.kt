package com.example.dora

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.dora.bean.Menu

class MenuListAdapter(menus: MutableList<Menu>) : BaseQuickAdapter<Menu, BaseViewHolder>(
    R.layout.item_menu_list, menus) {

    override fun convert(holder: BaseViewHolder, item: Menu) {
        holder.setText(R.id.tv_menu_item_id, "${getItemPosition(item) + 1}")
        holder.setTextColor(R.id.tv_menu_item_id, item.color)
        holder.setText(R.id.tv_menu_item_title, item.title)
        holder.setTextColor(R.id.tv_menu_item_title, item.color)
    }
}