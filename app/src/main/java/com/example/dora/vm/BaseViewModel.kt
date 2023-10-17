package com.example.dora.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import dora.brvah.BaseAdapter
import dora.util.GlobalContext

open class BaseViewModel : ViewModel() {

    var listDecorationObservable = ObservableField<DividerItemDecoration>()
    var adapterObservable = ObservableField<BaseAdapter<*, *>>()

    init {
        listDecorationObservable.set(DividerItemDecoration(GlobalContext.get(), DividerItemDecoration.VERTICAL))
    }
}