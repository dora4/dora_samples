package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath
import com.example.dcache.R
import com.example.dcache.api.TestService
import com.example.dcache.databinding.ActivityNetTestBinding
import com.example.dcache.db.model.TestCaseModel2
import dora.BaseActivity
import dora.http.DoraHttp.net
import dora.http.DoraHttp.result
import dora.util.IntentUtils
import dora.util.StatusBarUtils

@Route(path = ARouterPath.ACTIVITY_NET_TEST)
class NetTestActivity : BaseActivity<ActivityNetTestBinding>() {

    private var isRunning: Boolean = false

    override fun getLayoutId(): Int {
        return R.layout.activity_net_test
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityNetTestBinding) {
        super.initData(savedInstanceState, binding)
        binding.ivRun.setOnClickListener {
            if (!isRunning) {
                net {
                    binding.ivRun.visibility = View.GONE
                    isRunning = true
                    val start = System.currentTimeMillis()
                    (0 until 10).forEach { i ->
                        val models = result(TestService::class) { sendGetTest(10) }?.data
                        loopPrint(binding.tvPrint, models)
                    }
                    binding.ivRun.visibility = View.VISIBLE
                    val end = System.currentTimeMillis()
                    val time = end - start
                    binding.tvPrint.text = "API调用测试完成，共耗时${time}ms"
                    isRunning = false
                }
            } else {
                Toast.makeText(this, "正在跑呢", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loopPrint(tvPrint: TextView, models: MutableList<TestCaseModel2>?) {
        tvPrint.text = "10次API调用测试\n\n"
        models?.forEach {
            printLine(tvPrint, it)
        }
    }

    private fun printLine(tvPrint: TextView, model: TestCaseModel2?) {
        if (model != null) {
            tvPrint.append("${model.booleanVal},${model.shortVal},${model.intVal}," +
                    "${model.longVal},${model.floatVal},${model.doubleVal}\n")
        } else {
            tvPrint.append("null\n")
        }
        mBinding.scrollView.scrollTo(0, tvPrint.height)
    }
}