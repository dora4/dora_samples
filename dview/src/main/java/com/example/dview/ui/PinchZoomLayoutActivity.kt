package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityPinchZoomLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraPinchZoomLayout

@Route(path = ARouterPath.ACTIVITY_PINCH_ZOOM_LAYOUT)
class PinchZoomLayoutActivity : BaseActivity<ActivityPinchZoomLayoutBinding>() {

    val pages: IntArray = intArrayOf(
        R.drawable.by_ren_hangs_photograph_depicting1,
        R.drawable.by_ren_hangs_photograph_depicting2)

    override fun getLayoutId(): Int {
        return R.layout.activity_pinch_zoom_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityPinchZoomLayoutBinding) {
        binding.imageViewer.setTouchListener(object : DoraPinchZoomLayout.TouchListener {
            override fun onClick(v: View, e: MotionEvent) {
                Toast.makeText(this@PinchZoomLayoutActivity, "单击(${e.rawX},${e.rawY})", Toast.LENGTH_SHORT).show()
            }

            override fun onDoubleClick(v: View, e: MotionEvent) {
                Toast.makeText(this@PinchZoomLayoutActivity, "双击(${e.rawX},${e.rawY})", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(v: View, e: MotionEvent) {
                Toast.makeText(this@PinchZoomLayoutActivity, "长按(${e.rawX},${e.rawY})", Toast.LENGTH_SHORT).show()
            }

        })
        binding.viewPager.adapter = object : PagerAdapter() {

            override fun getCount(): Int {
                return pages.size
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val imageView = ImageView(this@PinchZoomLayoutActivity)
                imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
                imageView.setImageResource(pages[position])
                container.addView(imageView)
                return imageView
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }
        }
    }
}