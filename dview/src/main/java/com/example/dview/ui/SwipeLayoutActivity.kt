package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.SampleAdapter
import com.example.dview.SampleItem
import com.example.dview.databinding.ActivitySwipeLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ViewUtils
import dora.widget.pull.SwipeLayout

@Route(path = ARouterPath.ACTIVITY_SWIPE_LAYOUT)
class SwipeLayoutActivity : BaseActivity<ActivitySwipeLayoutBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_swipe_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivitySwipeLayoutBinding) {
        val items = arrayListOf<SampleItem>()
        for (i in 1 until 21) {
            items.add(SampleItem("第${i}个条目"))
        }
        ViewUtils.configRecyclerView(binding.recyclerView).adapter = SampleAdapter(items)
        binding.swipeLayout.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {

            override fun onRefresh(swipeLayout: SwipeLayout) {
                Handler(Looper.getMainLooper()).postDelayed({
                    swipeLayout.refreshFinish(SwipeLayout.SUCCEED)
                }, 1000)
            }

            override fun onLoadMore(swipeLayout: SwipeLayout) {
                Handler(Looper.getMainLooper()).postDelayed({
                    swipeLayout.loadMoreFinish(SwipeLayout.DONE)
                }, 1000)
            }
        })
    }
}