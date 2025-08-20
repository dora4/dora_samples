package com.example.dcache.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmQueryDataBinding

@Route(path = ARouterPath.ACTIVITY_ORM_QUERY_DATA)
class OrmQueryDataActivity : BaseActivity<ActivityOrmQueryDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_query_data
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmQueryDataBinding) {
    }
}