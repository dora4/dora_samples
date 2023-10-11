package com.example.dora

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:click")
        fun bindClick(view: View, listener: OnClickListener) {
            view.setOnClickListener(listener)
        }

        @JvmStatic
        @BindingAdapter("android:adapter")
        fun <T, B : ViewDataBinding> bindAdapter(recyclerView: RecyclerView, adapter: BaseAdapter<T, B>) {
            recyclerView.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("android:itemDecoration")
        fun bindItemDecoration(recyclerView: RecyclerView, decoration: ItemDecoration) {
            recyclerView.addItemDecoration(decoration)
        }
    }
}