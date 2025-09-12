package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityFlipperViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraFlipperView

@Route(path = ARouterPath.ACTIVITY_FLIPPER_VIEW)
class FlipperViewActivity : BaseActivity<ActivityFlipperViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_flipper_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityFlipperViewBinding) {
        binding.fv1.setFlipperListener(object : DoraFlipperView.FlipperListener {

            override fun onFlipFinish() {
            }

            override fun onFlipStart() {
            }

            override fun onItemClick(text: String) {
            }
        })
        // 航班 1
        binding.fv1.addText("航班号: CA123")
        binding.fv1.addText("出发地: 北京(PEK)")
        binding.fv1.addText("目的地: 上海(SHA)")
        binding.fv1.addText("起飞时间: 08:30")
        binding.fv1.addText("到达时间: 10:50")

        // 航班 2
        binding.fv2.addText("航班号: MU456")
        binding.fv2.addText("出发地: 广州(CAN)")
        binding.fv2.addText("目的地: 成都(CTU)")
        binding.fv2.addText("起飞时间: 13:15")
        binding.fv2.addText("到达时间: 15:55")

        // 航班 3
        binding.fv3.addText("航班号: CZ789")
        binding.fv3.addText("出发地: 深圳(SZX)")
        binding.fv3.addText("目的地: 西安(XIY)")
        binding.fv3.addText("起飞时间: 17:40")
        binding.fv3.addText("到达时间: 20:20")

        // 航班 4
        binding.fv4.addText("航班号: HU321")
        binding.fv4.addText("出发地: 香港(HKG)")
        binding.fv4.addText("目的地: 北京(PEK)")
        binding.fv4.addText("起飞时间: 21:10")
        binding.fv4.addText("到达时间: 23:55")
    }
}