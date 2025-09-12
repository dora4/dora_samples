package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityDrawableBinding
import dora.util.DoraDrawables
import dora.util.DoraDrawables.setCircleBackground
import dora.util.DoraDrawables.setDrawableBackground
import dora.util.DoraDrawables.setRoundedBackground
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_DRAWABLE)
class DrawableActivity : BaseActivity<ActivityDrawableBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_drawable
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityDrawableBinding) {
        val root = binding.llShapes.apply {
            layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            orientation = LinearLayout.HORIZONTAL
            setPadding(32, 32, 32, 32)
        }
        val lp = MarginLayoutParams(100, 100)
        lp.marginStart = 20
        // 圆角矩形背景
        val rounded = View(this).apply {
            layoutParams = lp
            setPadding(40, 20, 40, 20)
            setRoundedBackground(Color.parseColor("#4CAF50"), 30f)
        }

        // 圆形背景
        val circle = View(this).apply {
            layoutParams = lp
            setPadding(40, 40, 40, 40)
            setCircleBackground(Color.parseColor("#F44336"))
        }

        // 带边框的矩形
        val bordered = View(this).apply {
            layoutParams = lp
            setPadding(40, 20, 40, 20)
            background = DoraDrawables.borderedRect(
                fillColor = Color.YELLOW,
                radius = 20f,
                stroke = 6,
                strokeColor = Color.BLACK
            )
        }

        // 三角形
        val triangle = View(this).apply {
            layoutParams = lp
            setPadding(40, 20, 40, 20)
            setDrawableBackground(
                DoraDrawables.createTriangle(Color.MAGENTA)
            )
        }

        // 星星
        val star = View(this).apply {
            layoutParams = lp
            setPadding(40, 20, 40, 20)
            setDrawableBackground(
                DoraDrawables.createStar(Color.CYAN)
            )
        }

        // 扇形
        val sector = View(this).apply {
            layoutParams = lp
            setPadding(40, 20, 40, 20)
            setDrawableBackground(
                DoraDrawables.createSector(
                    Color.parseColor("#FF9800"),
                    startAngle = 0f,
                    sweepAngle = 120f
                )
            )
        }

        root.addView(rounded)
        root.addView(circle)
        root.addView(bordered)
        root.addView(triangle)
        root.addView(star)
        root.addView(sector)
    }
}