package com.example.app

import com.example.app.bean.Menu
import com.example.app.databinding.ItemMenuListBinding
import dora.arouter.open
import dora.brvah.BaseAdapter

class MenuListAdapter(menus: MutableList<Menu>) : BaseAdapter<Menu, ItemMenuListBinding>(
    R.layout.item_menu_list, menus) {

    override fun convert(holder: DoraViewHolder<ItemMenuListBinding>, item: Menu) {
        super.convert(holder, item)
        // 使用data binding
        holder.binding?.menu = item
        holder.setText(R.id.tv_menu_item_id, "${getItemPosition(item) + 1}")

        // 设置item点击事件
        setOnItemClickListener { adapter, _, position ->
            open((adapter.getItem(position) as Menu).path)
        }
    }
}