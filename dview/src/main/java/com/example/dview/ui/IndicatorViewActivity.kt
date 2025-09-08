package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityIndicatorViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_INDICATOR_VIEW)
class IndicatorViewActivity : BaseActivity<ActivityIndicatorViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_indicator_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityIndicatorViewBinding) {
        val items = listOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")
        binding.viewPager.adapter = object : RecyclerView.Adapter<TextVH>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextVH {
                val tv = TextView(parent.context).apply {
                    textSize = 24f
                    gravity = Gravity.CENTER
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
                return TextVH(tv)
            }
            override fun getItemCount() = items.size
            override fun onBindViewHolder(holder: TextVH, position: Int) {
                holder.textView.text = items[position]
            }
        }

        // 设置指示器 count
        binding.indicator.post {
            binding.indicator.apply {
                // 如果不想写死，可以在这里动态设置
                // count = items.size
            }
        }

        // 绑定 pageChangeCallback
        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                binding.indicator.pageChangeCallback.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.indicator.pageChangeCallback.onPageSelected(position)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                binding.indicator.pageChangeCallback.onPageScrolled(position, positionOffset,
                    positionOffsetPixels)
            }
        })
    }

    class TextVH(val textView: TextView) : RecyclerView.ViewHolder(textView)
}