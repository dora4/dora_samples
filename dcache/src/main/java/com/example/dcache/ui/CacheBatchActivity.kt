package com.example.dcache.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.ARouterPath

import dora.BaseActivity

import com.example.dcache.R
import com.example.dcache.adapter.TestCaseModelAdapter
import com.example.dcache.repository.TestRepository
import com.example.dcache.databinding.ActivityCacheBatchBinding
import com.example.dcache.model.TestCaseModel4
import dora.cache.repository.DoraPageDatabaseCacheRepository
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.StatusBarUtils
import dora.util.ViewUtils
import dora.widget.DoraEmptyLayout
import dora.widget.pull.SwipeLayout

@Route(path = ARouterPath.ACTIVITY_CACHE_BATCH)
class CacheBatchActivity : BaseActivity<ActivityCacheBatchBinding>() {

    private lateinit var repository: TestRepository
    private val adapter = TestCaseModelAdapter()

    override fun getLayoutId(): Int {
        return R.layout.activity_cache_batch
    }

    override fun onGetExtras(action: String?, bundle: Bundle?, intent: Intent) {
        mBinding.titleBar.title = IntentUtils.getStringExtra(intent, "title")
        val themeColor = IntentUtils.getIntExtra(intent, "themeColor")
        mBinding.titleBar.setBackgroundColor(themeColor)
        StatusBarUtils.setStatusBar(this, themeColor)
    }

    override fun initData(savedInstanceState: Bundle?, binding: ActivityCacheBatchBinding) {
        repository = TestRepository(this)
        val tvStart = findViewById<TextView>(R.id.tvStart)
        val tvReset = findViewById<TextView>(R.id.tvReset)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emptyLayout = findViewById<DoraEmptyLayout>(R.id.emptyLayout)
        val swipeLayout = findViewById<SwipeLayout>(R.id.swipeLayout)
        tvStart.setOnClickListener {
            repository.onRefresh()
        }
        tvReset.setOnClickListener {
            DaoFactory.getDao(TestCaseModel4::class.java).deleteAll()
            adapter.setList(null)
            emptyLayout.showEmpty()
        }
        ViewUtils.configRecyclerView(recyclerView).adapter = adapter
        repository.observeData(this, object : DoraPageDatabaseCacheRepository.AdapterDelegate<TestCaseModel4> {

            override fun addData(data: MutableList<TestCaseModel4>) {
                adapter.addData(data)
                emptyLayout.showContent()
            }

            override fun setList(data: MutableList<TestCaseModel4>) {
                adapter.setList(data)
                emptyLayout.showContent()
            }
        })
        swipeLayout.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {

            override fun onRefresh(swipeLayout: SwipeLayout) {
            }

            override fun onLoadMore(swipeLayout: SwipeLayout) {
                repository.onLoadMore {
                    swipeLayout.loadMoreFinish(if (it) SwipeLayout.SUCCEED else SwipeLayout.FAIL)
                }
            }
        })
        if (DaoFactory.getDao(TestCaseModel4::class.java).count() > 0) {
            adapter.setList(DaoFactory.getDao(TestCaseModel4::class.java).selectAll())
            emptyLayout.showContent()
        }
    }
}