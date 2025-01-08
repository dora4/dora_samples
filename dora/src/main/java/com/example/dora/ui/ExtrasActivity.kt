package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityExtrasBinding
import dora.BaseActivity
import dora.arouter.open

@Route(path = ARouterPath.ACTIVITY_EXTRAS)
class ExtrasActivity : BaseActivity<ActivityExtrasBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_extras
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityExtrasBinding) {
        open(ARouterPath.ACTIVITY_WEB_VIEW) {
            // 闭包中定义传参
            withString("url", "https://github.com/dora4");
//            withInt("other_params", 0);
        }
    }
}