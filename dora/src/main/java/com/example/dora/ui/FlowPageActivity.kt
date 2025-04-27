package com.example.dora.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityFlowPageBinding
import dora.BaseFragment
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_FLOW_PAGE)
class FlowPageActivity : BaseActivity<ActivityFlowPageBinding>() {

    private val pages = arrayListOf<BaseFragment<*>>()
    private val pageOne = FlowPageOneFragment()
    private val pageTwo = FlowPageTwoFragment()
    private val pageThree = FlowPageThreeFragment()

    override fun getLayoutId(): Int {
        return R.layout.activity_flow_page
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityFlowPageBinding) {
        binding.v = this
        pages.add(pageOne)
        pages.add(pageTwo)
        pages.add(pageThree)
        showPage(FlowPageOneFragment.PAGE_KEY)
    }

    override fun isPageLoop(): Boolean {
        return false
    }

    override fun getFlowFragment(key: String): BaseFragment<*> {
        return when (key) {
            FlowPageOneFragment.PAGE_KEY -> FlowPageOneFragment()
            FlowPageTwoFragment.PAGE_KEY -> FlowPageTwoFragment()
            FlowPageThreeFragment.PAGE_KEY -> FlowPageThreeFragment()
            else -> FlowPageOneFragment()
        }
    }

    override fun getFlowFragmentPageKeys(): Array<String> {
        return arrayOf(
            FlowPageOneFragment.PAGE_KEY,
            FlowPageTwoFragment.PAGE_KEY,
            FlowPageThreeFragment.PAGE_KEY
        )
    }

    override fun getFlowFragmentContainerId(): Int {
        return R.id.fl_flow_container
    }
}