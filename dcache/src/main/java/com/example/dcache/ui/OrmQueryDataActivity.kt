package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import androidx.appcompat.widget.AppCompatSpinner
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmQueryDataBinding
import com.example.dcache.model.OrmTestModel
import dora.db.builder.WhereBuilder
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraAlertDialog

@Route(path = ARouterPath.ACTIVITY_ORM_QUERY_DATA)
class OrmQueryDataActivity : BaseActivity<ActivityOrmQueryDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_query_data
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmQueryDataBinding) {
        binding.v = this
        showData()
    }

    fun addFilter() {
        showInputDialog()
    }

    private fun showInputDialog() {
        DoraAlertDialog(this).show(createInputView()) {
            val spinner: AppCompatSpinner = it.findViewById(R.id.spinner)
            val et1: EditText = it.findViewById(R.id.et1)
            val et2: EditText = it.findViewById(R.id.et2)
            var pos: Int = 0
            spinner.onItemSelectedListener = object : OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    pos = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
            positiveListener {
                val condition = when (pos) {
                    0 -> WhereBuilder.create().addWhereEqualTo(et1.text.toString().trim(), et2.text.toString().trim()).toCondition()
                    1 -> WhereBuilder.create().addWhereNotEqualTo(et1.text.toString().trim(), et2.text.toString().trim()).toCondition()
                    2 -> WhereBuilder.create().addWhereGreaterThan(et1.text.toString().trim(), et2.text.toString().toDouble()).toCondition()
                    3 -> WhereBuilder.create().addWhereGreaterThanOrEqualTo(et1.text.toString().trim(), et2.text.toString().toDouble()).toCondition()
                    4 -> WhereBuilder.create().addWhereLessThan(et1.text.toString().trim(), et2.text.toString().toDouble()).toCondition()
                    5 -> WhereBuilder.create().addWhereLessThanOrEqualTo(et1.text.toString().trim(), et2.text.toString().toDouble()).toCondition()
                    else -> WhereBuilder.create().addWhereEqualTo(et1.text.toString().trim(), et2.text.toString().trim()).toCondition()
                }
                val displayData = DaoFactory.getDao(OrmTestModel::class.java).select(WhereBuilder.create(
                    condition
                ))
                mBinding.tvOrmDisplay.text = ""
                displayData.iterator().forEach {
                    mBinding.tvOrmDisplay.append("\nstring值：${it.stringVal}\nint值：${it.intVal}\n")
                }
            }
        }
    }

    private fun createInputView(): View {
        val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_query_filter, null)
        contentView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        return contentView
    }

    private fun showData() {
        val displayData = DaoFactory.getDao(OrmTestModel::class.java).selectAll()
        mBinding.tvOrmDisplay.text = ""
        displayData.iterator().forEach {
            mBinding.tvOrmDisplay.append("\nstring值：${it.stringVal}\nint值：${it.intVal}\n")
        }
    }
}