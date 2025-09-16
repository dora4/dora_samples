package com.example.dcache.api

import com.example.common.model.ApiResult
import com.example.dcache.model.TestCaseModel
import com.example.dcache.model.TestCaseModel2
import com.example.dcache.model.TestCaseModel4
import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TestService : ApiService {

    @POST("openApi/test")
    @FormUrlEncoded
    fun sendPostTest(@Field("pageSize") pageSize: Int): Call<ApiResult<MutableList<TestCaseModel>>>

    @GET("openApi/test")
    fun sendGetTest(@Query("pageSize") pageSize: Int): Call<ApiResult<MutableList<TestCaseModel2>>>

    @POST("openApi/pageTest")
    @FormUrlEncoded
    fun sendPostPageTest(@Field("pageSize") pageSize: Int, @Field("pageNo") pageNo: Int): Call<TestPageResult<PageDTO<TestCaseModel4>>>

    @GET("openApi/pageTest")
    fun sendGetPageTest(@Query("pageSize") pageSize: Int, @Query("pageNo") pageNo: Int): Call<TestPageResult<PageDTO<TestCaseModel>>>
}