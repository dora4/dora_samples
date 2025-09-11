package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityBookPagerBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_BOOK_PAGER)
class BookPagerActivity : BaseActivity<ActivityBookPagerBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_book_pager
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityBookPagerBinding) {
        binding.bookPager.setPages(arrayListOf(
            "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容" +
                    "第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容第一页内容",
            "第二页内容第二页内容第二页内容",
            "第三页内容第三页内容第三页内容")
        )
    }
}