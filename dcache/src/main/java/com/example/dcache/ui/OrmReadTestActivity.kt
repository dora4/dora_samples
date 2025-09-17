package com.example.dcache.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dcache.R
import com.example.dcache.databinding.ActivityOrmReadTestBinding
import com.example.dcache.db.model.TestCaseModel2
import dora.BaseActivity
import dora.db.builder.WhereBuilder
import dora.db.dao.DaoFactory
import dora.http.DoraHttp
import dora.http.DoraHttp.net
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import kotlin.random.Random

@Route(path = ARouterPath.ACTIVITY_ORM_READ_TEST)
class OrmReadTestActivity : BaseActivity<ActivityOrmReadTestBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_orm_read_test
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityOrmReadTestBinding) {
        super.initData(savedInstanceState, binding)
        net {
            writeObjects()
            readObjects()
            DaoFactory.getDao(TestCaseModel2::class.java).deleteAll()
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
        val tvOrmReadResult = findViewById<TextView>(R.id.tvOrmReadResult)
        tvOrmReadResult.text = "正在准备数据"
        val time = DoraHttp.request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = getRandomObject()
                    model.index = i
                    DaoFactory.getDao(TestCaseModel2::class.java).insert(model)
                    runOnUiThread {
                        tvOrmReadResult.text = "正在准备第${i + 1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmReadResult.text = "数据准备完成"
    }

    private suspend fun readObjects() {
        val tvOrmReadResult = findViewById<TextView>(R.id.tvOrmReadResult)
        tvOrmReadResult.text = "开始执行读取数据操作"
        val time = DoraHttp.request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = DaoFactory.getDao(TestCaseModel2::class.java).selectOne(
                        WhereBuilder.create().addWhereEqualTo(
                            "data_index", i))
                    runOnUiThread {
                        tvOrmReadResult.text = "正在读取第${i + 1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmReadResult.text = "数据读取测试完成，共耗时${time}ms"
    }
}