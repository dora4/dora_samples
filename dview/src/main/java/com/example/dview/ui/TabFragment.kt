package com.example.dview.ui

import android.os.Bundle
import com.example.dview.R
import com.example.dview.databinding.FragmentTabBinding
import dora.BaseFragment

class TabFragment : BaseFragment<FragmentTabBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_tab
    }

    override fun initData(savedInstanceState: Bundle?, binding: FragmentTabBinding) {
        binding.tvPage.text = requireArguments().getString("page")
    }
}