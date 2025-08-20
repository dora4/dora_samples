package com.example.dcache.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmDeleteDataBinding

@Route(path = ARouterPath.ACTIVITY_ORM_DELETE_DATA)
class OrmDeleteDataActivity : BaseActivity<ActivityOrmDeleteDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_delete_data
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmDeleteDataBinding) {
    }
}