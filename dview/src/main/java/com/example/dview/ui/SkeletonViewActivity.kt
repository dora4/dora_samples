package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivitySkeletonViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraCircleImageView

@Route(path = ARouterPath.ACTIVITY_SKELETON_VIEW)
class SkeletonViewActivity : BaseActivity<ActivitySkeletonViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_skeleton_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivitySkeletonViewBinding) {
        Handler(Looper.getMainLooper()).postDelayed({
            // 1. inflate 正文内容
            val inflated = binding.content.viewStub?.inflate()
            inflated?.apply {
                // 2. 设置圆形图片
                findViewById<DoraCircleImageView>(R.id.civ1)
                    .setImageResource(R.drawable.shape_circle_card1)
                findViewById<DoraCircleImageView>(R.id.civ2)
                    .setImageResource(R.drawable.shape_circle_card2)
                findViewById<DoraCircleImageView>(R.id.civ3)
                    .setImageResource(R.drawable.shape_circle_card3)
                findViewById<DoraCircleImageView>(R.id.civ4)
                    .setImageResource(R.drawable.shape_circle_card4)
            }
            // 3. 隐藏骨架屏
            binding.skeletonCircle.visibility = View.GONE
            binding.skeletonCircle2.visibility = View.GONE
            binding.skeletonCircle3.visibility = View.GONE
            binding.skeletonCircle4.visibility = View.GONE
            binding.skeletonRect.visibility = View.GONE
            binding.skeletonRect2.visibility = View.GONE
            binding.skeletonRect3.visibility = View.GONE
        }, 1000)
    }
}