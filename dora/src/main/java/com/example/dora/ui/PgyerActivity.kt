package com.example.dora.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityPgyerBinding
import dora.pgyer.PgyVersionUpdate
import dora.util.ApkUtils

@Route(path = ARouterPath.ACTIVITY_PGYER)
class PgyerActivity : BaseActivity<ActivityPgyerBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_pgyer
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityPgyerBinding) {
        binding.tvCurVersion.text = "当前版本：${ApkUtils.getVersionName(this)}"
        binding.btnCheckUpdate.setOnClickListener {
            PgyVersionUpdate.checkVersion(this, "b32485d39298de8a302c67883e192107",
                "bc6564719d7a3b984fbffe2ebfc72901", object : PgyVersionUpdate.UpdateListener {
                    override fun onError(msg: String) {
                        showShortToast(msg)
                    }

                    override fun onLatestVersion() {
                        showShortToast("已经是最新版本了")
                    }

                    override fun onUpdate(
                        versionCode: Int,
                        versionName: String,
                        isForceUpdate: Boolean,
                        updateLog: String,
                        downloadUrl: String
                    ) {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(downloadUrl)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        try {
                            startActivity(intent)
                        } catch (ignore: ActivityNotFoundException) {
                        }
                    }
                })
        }
    }
}