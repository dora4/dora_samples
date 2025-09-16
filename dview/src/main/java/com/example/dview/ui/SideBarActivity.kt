package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.SparseArray
import androidx.core.content.ContextCompat
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
import java.util.Locale

@Route(path = ARouterPath.ACTIVITY_SIDE_BAR)
class SideBarActivity : BaseActivity<ActivitySideBarBinding>() {

    private val adapter by lazy {
        LetterAdapter(this,
            20f,
            ContextCompat.getColor(this,
            com.example.common.R.color.colorTextNormal))
    }
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
            .setSelectedTextColor(Color.parseColor("#04d5d5"))
            .setUnSelectTextColor(Color.parseColor("#646464"))
            .setSelectedBgColor(Color.parseColor("#ffffff"))
            .setUnSelectBgColor(Color.parseColor("#eeeeee"))
            .setTextXOffset(DensityUtils.dp2px(this, 12f).toFloat())
            .setTextSize(DensityUtils.sp2px(this, 18f).toFloat())
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
        // 更新侧边栏字母
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
        content.add("over")
        content.add("under")
        content.add("between")
        content.add("through")
        content.add("before")
        content.add("after")
        content.add("about")
        content.add("above")
        content.add("below")
        content.add("near")
        content.add("far")
        content.add("again")
        content.add("always")
        content.add("never")
        content.add("often")
        content.add("sometimes")
        content.add("together")
        content.add("apart")
        content.add("inside")
        content.add("outside")
        content.add("around")
        content.add("behind")
        content.add("beside")
        content.add("across")
        content.add("against")
        content.add("during")
        content.add("without")
        content.add("within")
        content.add("beyond")
        content.add("toward")
        content.add("upon")
        content.add("along")
        content.add("off")
        content.add("onto")
        content.add("up")
        content.add("down")
        content.add("left")
        content.add("right")
        content.add("forward")
        content.add("back")
        content.add("fast")
        content.add("slow")
        content.add("high")
        content.add("low")
        content.add("nearby")
        content.add("distant")
        content.add("early")
        content.add("late")
        content.add("young")
        content.add("old")
        content.add("new")
        content.add("ancient")
        content.add("big")
        content.add("small")
        content.add("short")
        content.add("long")
        content.add("wide")
        content.add("narrow")
        content.add("strong")
        content.add("weak")
        content.add("hot")
        content.add("cold")
        content.add("warm")
        content.add("cool")
        content.add("happy")
        content.add("sad")
        content.add("angry")
        content.add("calm")
        content.add("bright")
        content.add("dark")
        content.add("light")
        content.add("heavy")
        content.add("easy")
        content.add("hard")
        content.add("rich")
        content.add("poor")
        content.add("true")
        content.add("false")

        // 更新侧边栏字母
        mBinding.sideBar.setIndicators(buildIndicatorSideLetter(content))
        adapter.setList(content)
        // 移除最后一个条目装饰
        mBinding.recyclerView.removeItemDecoration(mBinding.recyclerView
            .getItemDecorationAt(mBinding.recyclerView.itemDecorationCount - 1))
        // 添加条目装饰
        mBinding.sideBar.attachToRecyclerView(mBinding.recyclerView, decorationConfig, buildIndicatorSideLetter(content))
    }

    private fun buildIndicatorSideLetter(indicators: MutableList<String>) : SparseArray<String> {
        indicators.sort()
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