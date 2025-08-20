package com.example.dcache.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityCacheBatchBinding

@Route(path = ARouterPath.ACTIVITY_CACHE_BATCH)
class CacheBatchActivity : BaseActivity<ActivityCacheBatchBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_cache_batch
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCacheBatchBinding) {
    }
}