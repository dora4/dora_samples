package com.example.dora

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

abstract class BaseAdapter<T, B : ViewDataBinding>(private val layoutResId: Int, data: MutableList<T>) :
    BaseQuickAdapter<T, BaseAdapter.DoraViewHolder<B>>(layoutResId, data) {

    class DoraViewHolder<B>(view: View) : BaseViewHolder(view) {

        internal var binding: B? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoraViewHolder<B> {
        val binding: B = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            layoutResId, parent, false
        )
        val holder = DoraViewHolder<B>(binding.root)
        holder.binding = binding
        return holder
    }

    @CallSuper
    override fun convert(holder: DoraViewHolder<B>, item: T) {
        holder.binding?.root?.setOnClickListener {
            getOnItemClickListener()?.onItemClick(this, it, getItemPosition(item))
        }
        holder.binding?.root?.setOnLongClickListener {
            getOnItemLongClickListener()?.onItemLongClick(this, it, getItemPosition(item)) ?: false
        }
    }
}