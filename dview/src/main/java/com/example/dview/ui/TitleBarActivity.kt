package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityTitleBarBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ToastUtils
import dora.widget.DoraTitleBar

/**
 * 标题栏控件，是一种十分常用的控件，便捷配置标题栏的内容，同时适配了老年模式。
 */
@Route(path = ARouterPath.ACTIVITY_TITLE_BAR)
class TitleBarActivity : BaseActivity<ActivityTitleBarBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_title_bar
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTitleBarBinding) {
        // 完整写法，自己创建ImageView并调用addMenuButton添加
//        val imageView = AppCompatImageView(this)
//        val dp24 = DensityUtils.dp2px(this, 24f)
//        imageView.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
//        imageView.setImageResource(R.drawable.ic_save)
//        val imageView2 = AppCompatImageView(this)
//        imageView2.layoutParams = RelativeLayout.LayoutParams(dp24, dp24)
//        imageView2.setImageResource(R.drawable.ic_confirm)
        // 简单写法，直接配置icon
        binding.titleBar
            .addMenuButton(com.example.common.R.drawable.ic_save)
            .addMenuButton(com.example.common.R.drawable.ic_confirm)
            .setOnIconClickListener(object : DoraTitleBar.OnIconClickListener {
            override fun onIconBackClick(icon: AppCompatImageView) {
                ToastUtils.showShort("返回")
            }

            override fun onIconMenuClick(position: Int, icon: AppCompatImageView) {
                ToastUtils.showShort("点击了第${position+1}个菜单")
            }
        })
    }
}