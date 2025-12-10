package com.example.dcache.repository

import android.content.Context
import com.example.dcache.api.PageDTO
import com.example.dcache.api.TestPageResult
import com.example.dcache.api.TestService
import com.example.dcache.db.model.TestCaseModel4
import dora.cache.DoraPageListCallback
import dora.cache.data.adapter.PageListResultAdapter
import dora.cache.data.fetcher.OnLoadListener
import dora.cache.repository.DoraPageDatabaseCacheRepository
import dora.cache.repository.ListRepository
import dora.http.retrofit.RetrofitManager
import retrofit2.Callback

/**
 * 分页缓存示例。
 */
@ListRepository
class TestPageRepository(context: Context) : DoraPageDatabaseCacheRepository<TestCaseModel4>(context) {

    override fun onLoadFromNetwork(
        callback: DoraPageListCallback<TestCaseModel4>,
        listener: OnLoadListener?
    ) {
        // 这里采用了适配器对接口类型进行转换
        RetrofitManager.getService(TestService::class.java).sendPostPageTest(getPageSize(), getPageNo())
            .enqueue(PageListResultAdapter(callback) as Callback<TestPageResult<PageDTO<TestCaseModel4>>>)
    }
}