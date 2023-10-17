package com.example.dora

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.BindingAdapter

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:click")
        fun bindClick(view: View, listener: OnClickListener) {
            view.setOnClickListener(listener)
        }
    }
}