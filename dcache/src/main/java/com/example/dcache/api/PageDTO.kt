package com.example.dcache.api

import java.io.Serializable

class PageDTO<T> : Serializable {
    var pageNo = 0  // 当前第几页
    var pageNum = 0 // 共有几页
    var pageSize = 0 // 每页多少条数据
    var totalSize = 0 // 总共多少条数据
    var list: MutableList<T>? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}