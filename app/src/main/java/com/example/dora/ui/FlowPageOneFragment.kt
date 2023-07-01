package com.example.dora.ui

import android.os.Bundle

import dora.BaseFragment

import com.example.dora.R
import com.example.dora.databinding.FragmentFlowPageOneBinding

class FlowPageOneFragment : BaseFragment<FragmentFlowPageOneBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_flow_page_one
    }

    override fun initData(savedInstanceState: Bundle?) {
    }
}