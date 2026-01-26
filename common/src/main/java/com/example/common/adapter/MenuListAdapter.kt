package com.example.common.adapter

import com.example.common.R
import com.example.common.databinding.ItemMenuListBinding
import com.example.common.model.Menu
import dora.arouter.open
import dora.brvah.BaseAdapter
import dora.firebase.SpmUtils

class MenuListAdapter(menus: MutableList<Menu>) : BaseAdapter<Menu, ItemMenuListBinding>(
    R.layout.item_menu_list, menus) {

    override fun convert(holder: DoraViewHolder<ItemMenuListBinding>, item: Menu) {
        super.convert(holder, item)
        // 使用data binding
        holder.binding?.menu = item
        holder.setText(R.id.tv_menu_item_id, "${getItemPosition(item) + 1}")

        // 设置item点击事件
        setOnItemClickListener { adapter, _, position ->
            val menu = (adapter.getItem(position) as Menu)
            // 埋点统计
            SpmUtils.selectContent(context, menu.title)
            open(menu.path) {
                withString("title", menu.title)
                withInt("themeColor", menu.color)
            }
        }
    }
}