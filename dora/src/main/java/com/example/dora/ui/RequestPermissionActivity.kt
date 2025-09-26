package com.example.dora.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dora.R
import com.example.dora.databinding.ActivityRequestPermissionBinding
import dora.util.IntentUtils
import dora.util.PermissionHelper

@Route(path = ARouterPath.ACTIVITY_REQUEST_PERMISSION)
class RequestPermissionActivity : BaseActivity<ActivityRequestPermissionBinding>() {

    private lateinit var helper: PermissionHelper

    override fun getLayoutId(): Int {
        return R.layout.activity_request_permission
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityRequestPermissionBinding) {
        // 在onCreate()中初始化，要在onResume()之前完成
        helper = PermissionHelper.with(this).prepare(
            PermissionHelper.Permission.CALL_PHONE,
            PermissionHelper.Permission.WRITE_EXTERNAL_STORAGE
        )
        binding.btnRequestCallPhone.setOnClickListener {
            helper.permissions(
                PermissionHelper.Permission.CALL_PHONE
            ).request {
                if (it) {
                    showShortToast("已授予拨打电话的权限")
                } else {
                    showShortToast("未授予拨打电话的权限")
                }
            }
        }
        binding.btnRequestWriteFile.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager()) {
                    startActivity(IntentUtils.getRequestStoragePermissionIntent(packageName))
                } else {
                    showShortToast("已授予存储文件的权限")
                }
            } else {
                helper.permissions(
                    PermissionHelper.Permission.WRITE_EXTERNAL_STORAGE
                ).request {
                    if (it) {
                        showShortToast("已授予存储文件的权限")
                    } else {
                        showShortToast("未授予存储文件的权限")
                    }
                }
            }
        }
    }
}