package com.example.dview.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityDropDownLayoutBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraTitleBar
import dora.widget.DropDownLayout

@Route(path = ARouterPath.ACTIVITY_DROP_DOWN_LAYOUT)
class DropDownLayoutActivity : BaseActivity<ActivityDropDownLayoutBinding>(), View.OnClickListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_drop_down_layout
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityDropDownLayoutBinding) {
        binding.titleBar
            .addMenuButton(com.example.common.R.drawable.ic_dropdown)
            .setOnIconClickListener(object : DoraTitleBar.OnIconClickListener {
                override fun onIconBackClick(icon: AppCompatImageView) {
                }

                override fun onIconMenuClick(position: Int, icon: AppCompatImageView) {
                    if (binding.dropdownLayout.isShadowShown()) {
                        binding.dropdownLayout.hideDropDownView()
                    } else {
                        binding.dropdownLayout.showDropDownView()
                    }
                }
            })
        val view = LayoutInflater.from(this).inflate(R.layout.item_tags, null)
        view.findViewById<TextView>(R.id.tv1).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv2).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv3).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv4).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv5).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv6).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv7).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv8).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tv9).setOnClickListener(this)
        binding.dropdownLayout.setDropDownView(view)
        binding.dropdownLayout.setOnShadowClickListener(object : DropDownLayout.OnShadowClickListener {
            override fun onClickShadow(shadowLayer: View) {
                showShortToast("点击了菜单外面")
                binding.dropdownLayout.hideDropDownView()
            }
        })
    }

    override fun onClick(v: View?) {
        showShortToast("点击了${(v as TextView).text}")
        mBinding.dropdownLayout.hideDropDownView()
    }
}