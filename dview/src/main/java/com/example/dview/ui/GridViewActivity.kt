package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityGridViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraGridView
import dora.widget.gridview.Cell

@Route(path = ARouterPath.ACTIVITY_GRID_VIEW)
class GridViewActivity : BaseActivity<ActivityGridViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_grid_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityGridViewBinding) {
        binding.gridView.setData(
            arrayOf(
                Cell("A"), Cell("B"), Cell("A"), Cell("D"),
                Cell("E"), Cell("F"), Cell("G")
            ), 3
        )
        // 狸猫换太子
        binding.gridView.updateData(2, 0, Cell("C", Color.RED, Color.GRAY))
        binding.gridView.setOnCellSelectListener(object : DoraGridView.OnCellSelectListener {

            override fun onCellSelected(rowIndex: Int, columnIndex: Int, cell: Cell?) {
                showShortToast("选择格子($rowIndex,$columnIndex)")
            }
        })
    }
}
