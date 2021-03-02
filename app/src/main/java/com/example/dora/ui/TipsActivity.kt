package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityTipsBinding
import dora.BaseActivity
import dora.util.ToastUtils
import kotlinx.android.synthetic.main.activity_tips.*

@Route(path = ARouterPath.ACTIVITY_TIPS)
class TipsActivity : BaseActivity<ActivityTipsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_tips
    }

    override fun initData(savedInstanceState: Bundle?) {
        btn_tips_01.setOnClickListener {
            ToastUtils.showShort("ToastUtils.showShort()")
        }
        btn_tips_02.setOnClickListener {
            Thread {
                ToastUtils.showLong("ToastUtils.showLong()")
            }.start()
        }
    }
}