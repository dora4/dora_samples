package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityAudioWaveViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.WaveDirection

@Route(path = ARouterPath.ACTIVITY_AUDIO_WAVE_VIEW)
class AudioWaveViewActivity : BaseActivity<ActivityAudioWaveViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_audio_wave_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityAudioWaveViewBinding) {
        binding.awv.apply {
            setLineWidth(6f)
            setLineSpace(10f)
            setDuration(1000L)
            setWaveDirection(WaveDirection.VERTICAL)
            setWaveGravity(Gravity.BOTTOM)
            addBody(35, maxCount = 18)
            addBody(55, maxCount = 18)
            addBody(82, maxCount = 18)
            addBody(48, maxCount = 18)
            addBody(68, maxCount = 18)
            start()
        }
    }
}