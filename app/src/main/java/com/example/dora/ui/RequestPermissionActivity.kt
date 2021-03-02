package com.example.dora.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.dora.ARouterPath
import com.example.dora.R
import com.example.dora.databinding.ActivityRequestPermissionBinding
import com.example.dora.toast
import dora.BaseActivity
import dora.permission.PermissionManager
import dora.permission.runtime.Permission

/**
 * Android6.0以上申请运行时权限。
 */
@Route(path = ARouterPath.ACTIVITY_REQUEST_PERMISSION)
class RequestPermissionActivity : BaseActivity<ActivityRequestPermissionBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_request_permission
    }

    override fun initData(savedInstanceState: Bundle?) {
        //权限申请API
        PermissionManager
            .with(this)
            .runtime()
            .permission(Permission.WRITE_EXTERNAL_STORAGE, Permission.RECORD_AUDIO)
            .onGranted {
                toast("已授予权限")
            }
            .onDenied {
                toast("权限被拒绝")
            }
            .start()
    }
}