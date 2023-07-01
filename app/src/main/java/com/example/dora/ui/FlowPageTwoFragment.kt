package com.example.dora.ui

import android.os.Bundle

import dora.BaseFragment

import com.example.dora.R
import com.example.dora.databinding.FragmentFlowPageTwoBinding

class FlowPageTwoFragment : BaseFragment<FragmentFlowPageTwoBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_flow_page_two
    }

    override fun initData(savedInstanceState: Bundle?) {
    }
}