package com.example.dcache.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityCacheNonListDataBinding

@Route(path = ARouterPath.ACTIVITY_CACHE_NON_LIST_DATA)
class CacheNonListDataActivity : BaseActivity<ActivityCacheNonListDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_cache_non_list_data
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCacheNonListDataBinding) {
    }
}