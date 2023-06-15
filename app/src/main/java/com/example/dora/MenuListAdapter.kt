package com.example.dora

import com.example.dora.bean.Menu
import com.example.dora.databinding.ItemMenuListBinding

class MenuListAdapter(menus: MutableList<Menu>) : BaseAdapter<Menu, ItemMenuListBinding>(
    R.layout.item_menu_list, menus) {

    override fun convert(holder: DoraViewHolder<ItemMenuListBinding>, item: Menu) {
        super.convert(holder, item)
        holder.binding?.menu = item
        holder.setText(R.id.tv_menu_item_id, "${getItemPosition(item) + 1}")
//        holder.setTextColor(R.id.tv_menu_item_id, item.color)
//        holder.setText(R.id.tv_menu_item_title, item.title)
//        holder.setTextColor(R.id.tv_menu_item_title, item.color)
    }
}