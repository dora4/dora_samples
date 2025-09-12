package com.example.dview.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dview.R
import com.example.dview.databinding.ActivityListHelperBinding
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DiffItem
import dora.widget.DoraListHelper

@Route(path = ARouterPath.ACTIVITY_LIST_HELPER)
class ListHelperActivity : BaseActivity<ActivityListHelperBinding>() {

    private lateinit var controller: DoraListHelper.ListController<DiffItem, MyViewHolder>

    override fun getLayoutId(): Int {
        return R.layout.activity_list_helper
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityListHelperBinding) {
        val adapter = object : ListAdapter<DiffItem, MyViewHolder>(DoraListHelper.DIFF_CALLBACK) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val textView = TextView(parent.context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    textSize = 16f
                    setPadding(20, 20, 20, 20)
                    setBackgroundColor(getColor(com.example.common.R.color.dark_gold))
                    setTextColor(Color.WHITE)
                }
                return MyViewHolder(textView)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val item = getItem(position) as MyItem
                (holder.itemView as TextView).text = item.title
            }
        }

        // DoraListHelper 一站式构建
        controller = DoraListHelper.attach(binding.recyclerView, adapter) {
            divider(thickness = 2, color = Color.LTGRAY)
            // 示例1：普通线性列表
//            linear(vertical = true)

            // 示例2：换成网格布局
//             grid(spanCount = 3, spacing = 16, includeEdge = true)

            // 示例3：流式换行布局
             flow(itemSpacing = 12, lineSpacing = 16)
        }

        // 提交数据
        controller.submitList(
            listOf(
                MyItem(1, "第一项"),
                MyItem(2, "第二项"),
                MyItem(3, "第三项"),
                MyItem(4, "第四项"),
                MyItem(5, "第五项"),
                MyItem(6, "第六项"),
                MyItem(7, "第七项"),
                MyItem(8, "第八项")
            )
        )
    }

    data class MyItem(val itemId: Long, val title: String) : DiffItem(itemId)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}