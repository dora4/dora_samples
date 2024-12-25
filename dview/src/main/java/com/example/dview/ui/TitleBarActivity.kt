package com.example.dview.ui

import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.common.MessageEvent
import com.example.dview.R
import com.example.dview.databinding.ActivityTitleBarBinding
import dora.util.LogUtils
import dora.widget.DoraTitleBar
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_TITLE_BAR)
class TitleBarActivity : BaseActivity<ActivityTitleBarBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_title_bar
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTitleBarBinding) {
        // 完整写法
//        val imageView = AppCompatImageView(this)
//        val dp24 = DensityUtils.dp2px(this, 24f)
//        imageView.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
//        imageView.setImageResource(R.drawable.ic_save)
//        val imageView2 = AppCompatImageView(this)
//        imageView2.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
//        imageView2.setImageResource(R.drawable.ic_confirm)
        binding.titleBar
            .addMenuButton(com.example.common.R.drawable.ic_save)
            .addMenuButton(com.example.common.R.drawable.ic_confirm)
            .setOnIconClickListener(object : DoraTitleBar.OnIconClickListener {
            override fun onIconBackClick(icon: AppCompatImageView) {
                LogUtils.i("返回")
            }

            override fun onIconMenuClick(position: Int, icon: AppCompatImageView) {
                LogUtils.i("点击了第${position}个菜单")
            }
        })
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg: MessageEvent) {
    }
}