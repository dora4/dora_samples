package com.example.dcache.repository

import android.content.Context
import com.example.common.model.ApiResult
import com.example.dcache.api.TestService
import com.example.dcache.db.model.TestCaseModel3
import dora.cache.data.adapter.ListResultAdapter
import dora.cache.data.fetcher.OnLoadListener
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.ListRepository
import dora.http.DoraListCallback
import dora.http.retrofit.RetrofitManager
import retrofit2.Callback

/**
 * 普通缓存示例。
 */
@ListRepository
class TestRepository(context: Context) : DoraDatabaseCacheRepository<TestCaseModel3>(context) {

    // 重写一个对应的onLoadFromNetwork
    override fun onLoadFromNetwork(
        callback: DoraListCallback<TestCaseModel3>,
        listener: OnLoadListener?
    ) {
        // 这里采用了适配器对接口类型进行转换
        RetrofitManager.getService(TestService::class.java).sendGetListTest()
            .enqueue(ListResultAdapter(callback) as Callback<ApiResult<MutableList<TestCaseModel3>>>)

        // 你也可以不使用适配器
//        RetrofitManager.getService(TestService::class.java).sendGetListTest()
//            .enqueue(object : DoraCallback<ApiResult<MutableList<TestCaseModel3>>>() {
//                override fun onFailure(msg: String) {
//                    callback.onFailure(msg)
//                }
//
//                override fun onSuccess(model: ApiResult<MutableList<TestCaseModel3>>) {
//                    model.data?.let { callback.onSuccess(it) }
//                }
//            })
    }
}