package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.SparseArray
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivitySideBarBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.sidebar.adapter.LetterAdapter
import dora.widget.sidebar.decoration.DecorationConfig
import dora.widget.sidebar.decoration.SideBarItemDecoration
import dora.widget.sidebar.decoration.SpaceItemDecoration
import dora.widget.sidebar.util.DensityUtils
import java.util.Collections
import java.util.Locale

@Route(path = ARouterPath.ACTIVITY_SIDE_BAR)
class SideBarActivity : BaseActivity<ActivitySideBarBinding>() {


    private val adapter = LetterAdapter(this)
    private lateinit var decorationConfig: DecorationConfig

    override fun getLayoutId(): Int {
        return R.layout.activity_side_bar
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivitySideBarBinding) {
        decorationConfig = DecorationConfig.Builder()
            .setLine(1, Color.parseColor("#ebebeb"))
            .setSelectedTextColor(0x04, 0xd5, 0xd5)
            .setUnSelectTextColor(0x64, 0x64, 0x64)
            .setSelectedBgColor(0xff, 0xff, 0xff)
            .setUnSelectBgColor(0xee, 0xee, 0xee)
            .setTextXOffset(DensityUtils.dp2px(this, 12f).toFloat())
            .setTextSize(DensityUtils.dp2px(this, 14f).toFloat())
            .setHeight(DensityUtils.dp2px(this, 30f))
            .build()
        val content: ArrayList<String> = ArrayList()
        content.add("aba")
        content.add("bcb")
        content.add("bcc")
        content.add("cdd")
        content.add("ccd")
        content.add("dab")
        content.add("dac")
        content.add("dbb")
        content.add("dcb")
        content.add("dcd")
        content.add("dda")
        content.add("ddb")
        content.add("ddd")
        // 字母头在条目中第一次出现的位置
        val array = buildIndicatorSideLetter(content)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = adapter
        //更新侧边栏字母
        binding.sideBar.setIndicators(array)
        adapter.addData(content)
        binding.recyclerView.addItemDecoration(SpaceItemDecoration(1))
        binding.recyclerView.addItemDecoration(SideBarItemDecoration(array))
        binding.sideBar.attachToRecyclerView(binding.recyclerView, decorationConfig, array)

        updateData()
    }

    private fun updateData() {
        val content: ArrayList<String> = arrayListOf()
        content.add("few")
        content.add("little")
        content.add("more")
        content.add("and")
        content.add("less")
        content.add("other")
        content.add("on")
        content.add("this")
        content.add("that")
        content.add("or")
        content.add("in")
        content.add("out")
        content.add("at")
        content.add("with")
        content.add("where")
        content.add("how")
        content.add("when")

        // 更新侧边栏字母
        mBinding.sideBar.setIndicators(buildIndicatorSideLetter(content))
        adapter.setList(content)
        // 移除最后一个条目装饰
        mBinding.recyclerView.removeItemDecoration(mBinding.recyclerView
            .getItemDecorationAt(mBinding.recyclerView.itemDecorationCount - 1))
        // 添加条目装饰
        mBinding.sideBar.attachToRecyclerView(mBinding.recyclerView, decorationConfig, buildIndicatorSideLetter(content))
    }

    private fun buildIndicatorSideLetter(indicators: List<String>) : SparseArray<String> {
        Collections.sort(indicators)
        val array = SparseArray<String>()
        var lastUpperCaseLetter = ""
        for ((index, indicator) in indicators.withIndex()) {
            if (lastUpperCaseLetter != indicator.uppercase(Locale.getDefault()).substring(0, 1)) {
                array.put(index, indicator.uppercase(Locale.getDefault()).substring(0, 1))
            }
            lastUpperCaseLetter = indicator.uppercase(Locale.getDefault()).substring(0, 1)
        }
        return array
    }
}