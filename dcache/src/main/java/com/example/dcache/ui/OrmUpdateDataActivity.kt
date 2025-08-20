package com.example.dcache.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmUpdateDataBinding

@Route(path = ARouterPath.ACTIVITY_ORM_UPDATE_DATA)
class OrmUpdateDataActivity : BaseActivity<ActivityOrmUpdateDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_update_data
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmUpdateDataBinding) {
    }
}