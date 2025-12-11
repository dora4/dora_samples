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
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
        writeObjects()
        updateObjects()
        deleteObjects()
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

    private fun writeObjects() {
        val tv = findViewById<TextView>(R.id.tvOrmInsertResult)
        tv.text = "开始执行写入数据操作"
        Observable.create<Pair<Int, TestCaseModel2>> { emitter ->
            val start = System.currentTimeMillis()
            val dao = DaoFactory.getDao(TestCaseModel2::class.java)
            for (i in 0 until 10000) {
                val model = getRandomObject()
                model.index = i
                dao.insert(model)

                emitter.onNext(i to model)
            }
            emitter.onComplete()
            val duration = System.currentTimeMillis() - start
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { (i, model) ->
                    tv.text = "正在写入第${i + 1}条数据，${model}"
                },
                { e ->
                    tv.text = "写入出错：${e.message}"
                },
                {
                    tv.text = "数据写入测试完成"
                }
            )
    }

    private fun updateObjects() {
        val tv = findViewById<TextView>(R.id.tvOrmUpdateResult)
        tv.text = "开始执行更新数据操作"
        Observable.create<Pair<Int, TestCaseModel2>> { emitter ->
            val start = System.currentTimeMillis()
            val dao = DaoFactory.getDao(TestCaseModel2::class.java)
            for (i in 0 until 10000) {
                val model = getRandomObject()
                model.index = i
                dao.update(
                    WhereBuilder.create().addWhereEqualTo("data_index", i),
                    model
                )
                emitter.onNext(i to model)
            }
            emitter.onComplete()
            val duration = System.currentTimeMillis() - start
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { (i, model) ->
                    tv.text = "正在更新第${i + 1}条数据，${model}"
                },
                { e ->
                    tv.text = "更新出错：${e.message}"
                },
                {
                    tv.text = "数据更新测试完成"
                }
            )
    }

    private fun deleteObjects() {
        val tv = findViewById<TextView>(R.id.tvOrmDeleteResult)
        tv.text = "开始执行删除数据操作"
        Observable.create<Pair<Int, Boolean>> { emitter ->
            val start = System.currentTimeMillis()
            val dao = DaoFactory.getDao(TestCaseModel2::class.java)
            for (i in 0 until 10000) {
                val ok = dao.delete(
                    WhereBuilder.create().addWhereEqualTo("data_index", i)
                )
                emitter.onNext(i to ok)
            }
            emitter.onComplete()
            val duration = System.currentTimeMillis() - start
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { (i, ok) ->
                    tv.text = "正在删除第${i + 1}条数据，删除结果：$ok"
                },
                { e ->
                    tv.text = "删除出错：${e.message}"
                },
                {
                    tv.text = "数据删除测试完成"
                }
            )
    }
}