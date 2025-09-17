package com.example.dcache.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.dcache.R
import com.example.dcache.db.model.TestCaseModel3
import dora.widget.panel.menu.AbsMenuPanelItem

class SwipeMenuPanelItem2(override var title: String?,
                          menu: TestCaseModel3
) : AbsMenuPanelItem<TestCaseModel3>(menu) {

    private var itemListener: ItemListener? = null

    override val layoutId: Int
        get() = R.layout.layout_menu_panel_swipe_menu

    override fun inflateView(context: Context): View {
        return LayoutInflater.from(context).inflate(layoutId, null)
    }

    override fun initData(menuView: View) {
        val lp = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lp.topMargin = marginTop
        menuView.layoutParams = lp
        val rlMenuPanelSwipeMenu =
            menuView.findViewById<RelativeLayout>(R.id.rl_menu_panel_swipe_menu)
        val tvMenuPanelSwipeMenu =
            menuView.findViewById<TextView>(R.id.tv_menu_panel_swipe_menu)
        val btnMenuPanelSwipeTagDelete =
            menuView.findViewById<Button>(R.id.btn_menu_panel_swipe_delete)
        tvMenuPanelSwipeMenu.text = menu.toString()
        rlMenuPanelSwipeMenu.setOnClickListener {
            itemListener?.onClick(menu)
        }
        btnMenuPanelSwipeTagDelete.setOnClickListener {
            itemListener?.onDelete(menu, this)
        }
    }

    fun setItemListener(l: ItemListener) {
        this.itemListener = l
    }

    interface ItemListener {
        fun onClick(model: TestCaseModel3)
        fun onDelete(model: TestCaseModel3, item: SwipeMenuPanelItem2)
    }
}