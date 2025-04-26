package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityIntroduceBinding
import dora.BaseActivity

@Route(path = ARouterPath.ACTIVITY_INTRODUCE)
class IntroduceActivity : BaseActivity<ActivityIntroduceBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_introduce
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityIntroduceBinding) {
        binding.introduce = "Android应用开发全家桶框架，https://github.com/dora4/dora。 它支持Java和Kotlin语言的Android应用开发，致力于帮助你打造一款高质量的Android App。它总共由三大板块组成，dora基础架构、dcache数据层架构、dview视图层架构。本App以简明扼要为宗旨，一个功能最大限度降低门槛，只涉及相关功能的代码。另外附加可操作性，让初学者可以轻松的理解演示的功能。且尽可能让布局精美，体验无限的游乐园乐趣。"
    }
}