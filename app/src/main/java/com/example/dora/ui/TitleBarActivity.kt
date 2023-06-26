package com.example.dora.ui

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.bean.MessageEvent
import com.example.dora.databinding.ActivityTitleBarBinding
import dora.util.DensityUtils
import dora.util.LogUtils
import dora.widget.DoraTitleBar
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Route(path = ARouterPath.ACTIVITY_TITLE_BAR)
class TitleBarActivity : BaseActivity<ActivityTitleBarBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_title_bar
    }

    override fun initData(savedInstanceState: Bundle?) {
        val imageView = AppCompatImageView(this)
        val dp24 = DensityUtils.dp2px(this, 24f)
        imageView.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
        imageView.setImageResource(R.drawable.ic_save)
        val imageView2 = AppCompatImageView(this)
        imageView2.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
        imageView2.setImageResource(R.drawable.ic_confirm)
        mBinding.titleBar
            .addMenuButton(imageView)
            .addMenuButton(imageView2)
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