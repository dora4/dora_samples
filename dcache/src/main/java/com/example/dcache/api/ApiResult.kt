package com.example.dcache.api

import dora.cache.data.adapter.PageResult

class ApiResult<T> : PageResult<T> {

    var code: String? = null
    var msg: String? = null
    var data: T? = null
        private set
    val timestamp = System.currentTimeMillis()

    fun setData(data: T) {
        this.data = data
    }

    override fun getRealModel(): T? {
        if (data is PageDTO<*>) {
            return (data as PageDTO<*>).list as T
        }
        return data
    }

    override fun getTotalSize(): Int {
        if (data is PageDTO<*>) {
            return (data as PageDTO<*>).totalSize
        }
        return 0
    }
}