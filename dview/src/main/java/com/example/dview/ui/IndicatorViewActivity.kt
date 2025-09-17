package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
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
        val items = listOf(R.drawable.by_lisi_martin1, R.drawable.by_lisi_martin2,
            R.drawable.by_lisi_martin3, R.drawable.by_lisi_martin4,
            R.drawable.by_molly_brett1, R.drawable.by_molly_brett2,
            R.drawable.by_molly_brett3, R.drawable.by_molly_brett4)
        binding.viewPager.adapter = object : RecyclerView.Adapter<ImageVH>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
                val iv = ImageView(parent.context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
                return ImageVH(iv)
            }
            override fun getItemCount() = items.size
            override fun onBindViewHolder(holder: ImageVH, position: Int) {
                holder.imageView.setImageResource(items[position])
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

    class ImageVH(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}