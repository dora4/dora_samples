package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.adapter.OrmTestModelAdapter
import com.example.dcache.databinding.ActivityOrmDeleteDataBinding
import com.example.dcache.model.OrmTestModel
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ViewUtils
import dora.widget.DoraAlertDialog
import kotlin.random.Random

@Route(path = ARouterPath.ACTIVITY_ORM_DELETE_DATA)
class OrmDeleteDataActivity : BaseActivity<ActivityOrmDeleteDataBinding>() {

    val adapter = OrmTestModelAdapter()

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_delete_data
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmDeleteDataBinding) {
        binding.v = this
        adapter.setOnItemClickListener { adapter, view, position ->
            DoraAlertDialog(this@OrmDeleteDataActivity)
                .show("是否删除此条数据？") {
                    positiveListener {
                        val model = adapter.getItem(position) as OrmTestModel
                        try {

                            val ok = DaoFactory.getDao(OrmTestModel::class.java).delete(model)
                            if (ok) {
                                adapter.removeAt(position)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
        }
        ViewUtils.configRecyclerView(binding.rv).adapter = adapter
        loadData()
    }

    private fun loadData() {
        adapter.setList(DaoFactory.getDao(OrmTestModel::class.java).selectAll())
    }

    fun insertData() {
        val model = generateRandomData()
        val id = DaoFactory.getDao(OrmTestModel::class.java).insertReturnId(model)
        if (id > 0) {
            // 想不查询出来就进行下一步操作？那就手动把id绑定到数据上吧！
            model.id = id
            adapter.addData(model)
            // 滚动到最后一项
            mBinding.rv.scrollToPosition(adapter.itemCount - 1)
        }
    }

    private fun generateRandomData(): OrmTestModel {
        val model = OrmTestModel()
        // 随机长度 1~10 的字符串，只包含字母和数字
        val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val strLength = Random.nextInt(1, 11)  // 1 到 10
        model.stringVal = (1..strLength)
            .map { chars.random() }
            .joinToString("")
        // 随机 1~9 位数字
        val number = Random.nextInt(1000000000)
        model.intVal = number
        return model
    }
}