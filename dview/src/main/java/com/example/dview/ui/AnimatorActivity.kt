package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityAnimatorBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.action.AlphaAction
import dora.widget.action.CubicTo
import dora.widget.action.LineTo
import dora.widget.action.MoveTo
import dora.widget.action.RotateAction
import dora.widget.action.ScaleAction

@Route(path = ARouterPath.ACTIVITY_ANIMATOR)
class AnimatorActivity : BaseActivity<ActivityAnimatorBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_animator
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityAnimatorBinding) {
        (LineTo(100f, 100f)
                + MoveTo(0f, 100f)
                + CubicTo(100f, 100f, 200f, 200f, 0f, 0f)
        ).startAnimation(binding.iv, 1000)
        (AlphaAction(0.3f) + AlphaAction(1.0f)).startAnimation(binding.iv, 2000)
        ScaleAction(1.2f, 1.2f).startAnimation(binding.iv, 3000)
        (RotateAction(90f) + RotateAction(0f)).startAnimation(binding.iv, 2000)
        LineTo(0f, 700f).startAnimation(binding.tv, 3000)
    }
}