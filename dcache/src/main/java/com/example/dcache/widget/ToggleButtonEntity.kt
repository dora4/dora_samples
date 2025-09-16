package com.example.dcache.widget

import dora.widget.panel.IMenu
import java.util.UUID

class ToggleButtonEntity @JvmOverloads constructor(
    var label: String,
    var isSelect: Boolean,
    var listener: OnSelectListener
) : IMenu {

    override val menuName: String
        get() = UUID.randomUUID().toString()

    interface OnSelectListener {
        fun onSelect(item: ToggleButtonMenuPanelItem, select: Boolean)
    }
}