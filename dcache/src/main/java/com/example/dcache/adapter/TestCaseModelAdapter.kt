package com.example.dcache.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.dcache.R
import com.example.dcache.db.model.TestCaseModel4

class TestCaseModelAdapter : BaseQuickAdapter<TestCaseModel4, BaseViewHolder>(R.layout.item_test_case_model) {

    override fun convert(holder: BaseViewHolder, item: TestCaseModel4) {
        holder.setText(R.id.tvResult,
                "布尔值：${item.booleanVal}\n" +
                "short值：${item.shortVal}\n" +
                "int值：${item.intVal}\n" +
                "long值：${item.longVal}\n" +
                "float值：${item.floatVal}\n" +
                "double值：${item.doubleVal}")
    }
}