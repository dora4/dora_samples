package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dview.R
import com.example.dview.databinding.ActivityTabLayoutBinding
import dora.BaseActivity
import dora.util.FragmentUtils
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraTabBar

@Route(path = ARouterPath.ACTIVITY_TAB_LAYOUT)
class TabLayoutActivity : BaseActivity<ActivityTabLayoutBinding>() {

    val pageOne = TabFragment()
    val pageTwo = TabFragment()
    val pageThree = TabFragment()

    override fun getLayoutId(): Int {
        return R.layout.activity_tab_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTabLayoutBinding) {
        binding.tabBar.addTextTab("频道1")
        binding.tabBar.addTextTab("频道2")
        binding.tabBar.addTextTab("频道3")
        binding.tabBar.setOnTabClickListener(object : DoraTabBar.OnTabClickListener {

            override fun onTabClick(view: View, position: Int) {
                when (position) {
                    0 -> {
                        showPage(pageOne)
                    }

                    1 -> {
                        showPage(pageTwo)
                    }

                    2 -> {
                        showPage(pageThree)
                    }
                }
            }
        })

        val argumentsOne = Bundle()
        val argumentsTwo = Bundle()
        val argumentsThree = Bundle()
        argumentsOne.putString("page", "页面1")
        argumentsTwo.putString("page", "页面2")
        argumentsThree.putString("page", "页面3")
        pageOne.arguments = argumentsOne
        pageTwo.arguments = argumentsTwo
        pageThree.arguments = argumentsThree
        showPage(pageOne)
    }

    private fun showPage(fragment: TabFragment) {
        hideFragments(arrayListOf(pageOne, pageTwo, pageThree) as Collection<TabFragment>)
        FragmentUtils.add(supportFragmentManager, fragment, R.id.fl_pages)
        FragmentUtils.show(fragment)
    }
}