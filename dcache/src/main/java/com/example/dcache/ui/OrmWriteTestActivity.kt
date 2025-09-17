package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmWriteTestBinding
import com.example.dcache.db.model.TestCaseModel2
import dora.BaseActivity
import dora.db.builder.WhereBuilder
import dora.db.dao.DaoFactory
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import kotlin.random.Random

@Route(path = ARouterPath.ACTIVITY_ORM_WRITE_TEST)
class OrmWriteTestActivity : BaseActivity<ActivityOrmWriteTestBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_write_test
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmWriteTestBinding) {
        super.initData(savedInstanceState, binding)
        net {
            writeObjects()
            updateObjects()
            deleteObjects()
        }
    }

    private fun getRandomObject(): TestCaseModel2 {
        val model = TestCaseModel2()
        model.booleanVal = Random.nextBoolean()
        model.shortVal = (Random.nextInt(65535) - 32767).toShort()
        model.intVal = Random.nextInt()
        model.longVal = Random.nextLong()
        model.floatVal = Random.nextFloat()
        model.doubleVal = Random.nextDouble()
        return model
    }

    private suspend fun writeObjects() {
        val tvOrmInsertResult = findViewById<TextView>(R.id.tvOrmInsertResult)
        tvOrmInsertResult.text = "开始执行写入数据操作"
        val time = request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = getRandomObject()
                    model.index = i
                    DaoFactory.getDao(TestCaseModel2::class.java).insert(model)
                    runOnUiThread {
                        tvOrmInsertResult.text = "正在写入第${i+1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmInsertResult.text = "数据写入测试完成，共耗时${time}ms"
    }

    private suspend fun updateObjects() {
        val tvOrmUpdateResult = findViewById<TextView>(R.id.tvOrmUpdateResult)
        tvOrmUpdateResult.text = "开始执行更新数据操作"
        val time = request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = getRandomObject()
                    model.index = i
                    DaoFactory.getDao(TestCaseModel2::class.java).update(
                        WhereBuilder.create().addWhereEqualTo("data_index", i),
                        model)
                    runOnUiThread {
                        tvOrmUpdateResult.text = "正在更新第${i+1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmUpdateResult.text = "数据更新测试完成，共耗时${time}ms"
    }

    private suspend fun deleteObjects() {
        val tvOrmDeleteResult = findViewById<TextView>(R.id.tvOrmDeleteResult)
        tvOrmDeleteResult.text = "开始执行删除数据操作"
        val time = request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val ok = DaoFactory.getDao(TestCaseModel2::class.java).delete(WhereBuilder.create().addWhereEqualTo("data_index", i))
                    runOnUiThread {
                        tvOrmDeleteResult.text = "正在删除第${i+1}条数据，删除结果：${ok}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmDeleteResult.text = "数据删除测试完成，共耗时${time}ms"
    }
}