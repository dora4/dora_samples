package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityMenuPanelBinding
import dora.util.DensityUtils
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItem
import dora.widget.panel.MenuPanelItemGroup
import dora.widget.panel.menu.NormalMenuPanelItem

@Route(path = ARouterPath.ACTIVITY_MENU_PANEL)
class MenuPanelActivity : BaseActivity<ActivityMenuPanelBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_menu_panel
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityMenuPanelBinding) {
         binding.menuPanel.addMenuGroup(
             MenuPanelItemGroup(
                 DensityUtils.DP10,
                 NormalMenuPanelItem("menu1", "菜单1", true, "角落文字1"),
                 NormalMenuPanelItem("menu2", "菜单2")
             )
         ).setOnPanelMenuClickListener(object : MenuPanel.OnPanelMenuClickListener {
             override fun onMenuClick(
                 position: Int,
                 view: View,
                 menuName: String,
                 item: MenuPanelItem
             ) {
                 when (menuName) {
                     "menu1" -> {
                         showShortToast("点击了菜单1")
                     }
                     "menu2" -> {
                         showShortToast("点击了菜单2")
                     }
                 }
             }
         })
    }
}