package com.example.dview

import com.example.dview.databinding.ItemSampleBinding
import dora.brvah.BaseAdapter

class SampleAdapter(menus: MutableList<SampleItem>) : BaseAdapter<SampleItem, ItemSampleBinding>(
    R.layout.item_sample, menus) {

    override fun convert(holder: DoraViewHolder<ItemSampleBinding>, item: SampleItem) {
        super.convert(holder, item)
        holder.binding?.item = item
        holder.setText(R.id.tv_sample, item.text)
    }
}