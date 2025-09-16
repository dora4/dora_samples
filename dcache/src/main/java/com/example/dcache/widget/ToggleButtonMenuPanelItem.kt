package com.example.dcache.widget

import android.view.View
import android.widget.TextView
import com.example.dcache.R
import dora.widget.DoraToggleButton
import dora.widget.panel.MenuPanelItemRoot
import dora.widget.panel.MenuPanelItemRoot.Companion.DEFAULT_TITLE_SPAN
import dora.widget.panel.menu.AbsMenuPanelItem

class ToggleButtonMenuPanelItem(menu: ToggleButtonEntity,
                                override var title: String?
) :
    AbsMenuPanelItem<ToggleButtonEntity>(MenuPanelItemRoot.DEFAULT_MARGIN_TOP,
        MenuPanelItemRoot.Span(DEFAULT_TITLE_SPAN), menu) {

    private var tbMenuPanelToggleArrow: DoraToggleButton? = null
    var listener: ToggleButtonEntity.OnSelectListener?

    init {
        listener = menu.listener
    }

    override val layoutId: Int
        get() = R.layout.layout_menu_panel_toggle_button

    fun setChecked(isChecked: Boolean) {
        menu.isSelect = isChecked
    }

    fun changeCheckedState() {
        menu.isSelect = tbMenuPanelToggleArrow!!.isChecked
    }

    override fun initData(menuView: View) {
        val tvMenuPanelToggleMenu =
            menuView.findViewById<TextView>(R.id.tv_menu_panel_toggle_menu)
        tbMenuPanelToggleArrow = menuView.findViewById(R.id.tb_menu_panel_toggle_arrow)
        tvMenuPanelToggleMenu.text = menu.label
        tbMenuPanelToggleArrow!!.isChecked = menu.isSelect
        listener = menu.listener
        tbMenuPanelToggleArrow!!.setOnCheckedChangeListener(object : DoraToggleButton.OnCheckedChangeListener {

            override fun onCheckedChanged(view: DoraToggleButton?, isChecked: Boolean) {
                listener?.onSelect(this@ToggleButtonMenuPanelItem, isChecked)
            }
        })
    }
}