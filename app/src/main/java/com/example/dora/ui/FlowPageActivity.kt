package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.MessageEvent

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityFlowPageBinding
import dora.BaseFragment
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_FLOW_PAGE)
class FlowPageActivity : BaseActivity<ActivityFlowPageBinding>() {

    val pages = arrayListOf<BaseFragment<*>>()
    val pageOne = FlowPageOneFragment()
    val pageTwo = FlowPageTwoFragment()
    val pageThree = FlowPageThreeFragment()

    override fun getLayoutId(): Int {
        return R.layout.activity_flow_page
    }

    override fun initData(savedInstanceState: Bundle?) {
        pages.add(pageOne)
        pages.add(pageTwo)
        pages.add(pageThree)
        showPage("page_one")
        mBinding.btnNextPage.setOnClickListener {
            nextPage()
        }
    }

    override fun isLoop(): Boolean {
        return false
    }

    override fun getFlowFragment(key: String): BaseFragment<*> {
        return when (key) {
            "page_one" -> FlowPageOneFragment()
            "page_two" -> FlowPageTwoFragment()
            "page_three" -> FlowPageThreeFragment()
            else -> FlowPageOneFragment()
        }
    }

    override fun getFlowFragmentPageKeys(): Array<String> {
        return arrayOf("page_one", "page_two", "page_three")
    }

    override fun getFlowFragmentContainerId(): Int {
        return R.id.fl_flow_container
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}