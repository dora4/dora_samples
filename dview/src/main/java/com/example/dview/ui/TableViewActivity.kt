package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityTableViewBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.tableview.TableCell

@Route(path = ARouterPath.ACTIVITY_TABLE_VIEW)
class TableViewActivity : BaseActivity<ActivityTableViewBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_table_view
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityTableViewBinding) {
        val data = listOf(
            TableCell("权益类别", isBold = true, textColor = Color.WHITE, backgroundColor = ContextCompat.getColor(this, dora.widget.colors.R.color.light_gray)),
            TableCell("普通用户", isBold = true, textColor = Color.WHITE, backgroundColor = ContextCompat.getColor(this, dora.widget.colors.R.color.light_gray)),
            TableCell("VIP会员", isBold = true, textColor = Color.WHITE, backgroundColor = ContextCompat.getColor(this, dora.widget.colors.R.color.light_gray)),

            TableCell("AES加/解密功能"),
            TableCell("✅ 支持"),
            TableCell("✅ 支持"),

            TableCell("RSA加/解密功能"),
            TableCell("✅ 支持"),
            TableCell("✅ 支持"),

            TableCell("文件加/解密功能"),
            TableCell("❌ 不支持"),
            TableCell("✅ 支持"),

            TableCell("去中心化时间锁功能"),
            TableCell("❌ 不支持"),
            TableCell("✅ 支持"),

            TableCell("授权平台数量"),
            TableCell("2 个"),
            TableCell("10 个"),

            TableCell("授权账号数量"),
            TableCell("10 个"),
            TableCell("100 个"),

            TableCell("直登账号数量"),
            TableCell("10 个"),
            TableCell("100 个"),

            TableCell("账号矩阵超额规则"),
            TableCell("/"),
            TableCell("\uD83D\uDD39 超出授权平台，每 10 个位置 / 19.8 POL\n" +
                    "\uD83D\uDD39 超出授权账号或直登账号，每 100 个位置 / 19.8 POL")
        )
        binding.tableView.setData(data, 3)
    }
}