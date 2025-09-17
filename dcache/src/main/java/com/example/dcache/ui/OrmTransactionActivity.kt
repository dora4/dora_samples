package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmTransactionBinding
import com.example.dcache.db.model.OrmTestModel
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import kotlin.random.Random

@Route(path = ARouterPath.ACTIVITY_ORM_TRANSACTION)
class OrmTransactionActivity : BaseActivity<ActivityOrmTransactionBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_transaction
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmTransactionBinding) {
        binding.v = this
        showData()
    }

    private fun showData() {
        val displayData = DaoFactory.getDao(OrmTestModel::class.java).selectAll()
        mBinding.tvOrmDisplay.text = ""
        displayData.iterator().forEach {
            mBinding.tvOrmDisplay.append("\nstring值：${it.stringVal}\nint值：${it.intVal}\n")
        }
    }

    fun insertDataInTx() {
        DaoFactory.getDao(OrmTestModel::class.java).runInTransaction {
            for (i in 0 until 3) {
                val model = generateRandomData()
                it.insert(model)
            }
        }
        showData()
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