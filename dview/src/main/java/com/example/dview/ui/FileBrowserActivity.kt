package com.example.dview.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dview.R
import com.example.dview.databinding.ActivityFileBrowserBinding
import dora.BaseActivity
import dora.widget.filebrowser.FileBrowser

@Route(path = ARouterPath.ACTIVITY_FILE_BROWSER)
class FileBrowserActivity : BaseActivity<ActivityFileBrowserBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_file_browser
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FileBrowser.REQUEST_CODE_CHOOSE_FILE) {

            }
        }
    }



    override fun initData(savedInstanceState: Bundle?, binding: ActivityFileBrowserBinding) {
        FileBrowser.chooseFile(this@FileBrowserActivity)
    }
}