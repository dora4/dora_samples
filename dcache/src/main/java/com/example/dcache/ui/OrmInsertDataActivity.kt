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
import com.example.dcache.databinding.ActivityOrmInsertDataBinding
import com.example.dcache.model.OrmTestModel
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.widget.DoraAlertDialog

@Route(path = ARouterPath.ACTIVITY_ORM_INSERT_DATA)
class OrmInsertDataActivity : BaseActivity<ActivityOrmInsertDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_insert_data
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmInsertDataBinding) {
        binding.v = this
        showData()
    }

    fun insertData() {
        showInputDialog {
            val ok = DaoFactory.getDao(OrmTestModel::class.java).insert(it)
            if (ok) showData()
        }
    }

    private fun showInputDialog(block: (model : OrmTestModel) -> Unit) {
        DoraAlertDialog(this).show(createInputView()) {
            val et1: EditText = it.findViewById(R.id.et1)
            val et2: EditText = it.findViewById(R.id.et2)
            positiveListener {
                val model = OrmTestModel()
                model.stringVal = et1.text.toString()
                model.intVal = et2.text.toString().toInt()
                block(model)
            }
        }
    }

    private fun createInputView(): View {
        val contentView = LayoutInflater.from(this).inflate(R.layout.dialog_input_content, null)
        contentView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        return contentView
    }

    fun deleteAllData() {
        DaoFactory.getDao(OrmTestModel::class.java).deleteAll()
        showData()
    }

    private fun showData() {
        val displayData = DaoFactory.getDao(OrmTestModel::class.java).selectAll()
        mBinding.tvOrmDisplay.text = ""
        displayData.iterator().forEach {
            mBinding.tvOrmDisplay.append("\nstring值：${it.stringVal}\nint值：${it.intVal}\n")
        }
    }
}