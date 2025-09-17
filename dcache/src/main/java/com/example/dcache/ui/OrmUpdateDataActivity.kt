package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.adapter.OrmTestModelAdapter
import com.example.dcache.databinding.ActivityOrmUpdateDataBinding
import com.example.dcache.db.model.OrmTestModel
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ViewUtils
import dora.widget.DoraAlertDialog

@Route(path = ARouterPath.ACTIVITY_ORM_UPDATE_DATA)
class OrmUpdateDataActivity : BaseActivity<ActivityOrmUpdateDataBinding>() {

    val adapter = OrmTestModelAdapter()

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_update_data
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmUpdateDataBinding) {
        binding.v = this
        adapter.setOnItemClickListener { _, view, position ->
            DoraAlertDialog(this).show(createInputView()) {
                val et1: EditText = it.findViewById(R.id.et1)
                val et2: EditText = it.findViewById(R.id.et2)
                positiveListener {
                    val model = adapter.getItem(position) as OrmTestModel
                    model.stringVal = et1.text.toString()
                    model.intVal = et2.text.toString().toInt()
                    val ok = DaoFactory.getDao(OrmTestModel::class.java).update(model)
                    if (ok) {
                        adapter.setData(position, model)
                    }
                }
            }
        }
        ViewUtils.configRecyclerView(binding.rv).adapter = adapter
        loadData()
    }

    private fun createInputView(): View {
        val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_input_content, null)
        contentView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        return contentView
    }

    private fun loadData() {
        adapter.setList(DaoFactory.getDao(OrmTestModel::class.java).selectAll())
    }
}