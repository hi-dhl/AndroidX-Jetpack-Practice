package com.hi.dhl.paging3.data

import androidx.paging.PagingConfig
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.mapper.Person2PersonEntityMapper
import com.hi.dhl.paging3.data.mapper.PersonEntity2PersonMapper
import com.hi.dhl.paging3.data.repository.PersonRepositoryImpl
import com.hi.dhl.paging3.data.repository.Repository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  : 用到 koin 的依赖注入 , 上层不需要关心 Repository 和  Mapper，隐藏了 Repository 和  Mapper 显示的依赖关系
 * </pre>
 */

class RepositoryFactory(val appDataBase: AppDataBase) {

    // 传递 PagingConfig 和 Data Mapper
    fun makeLocalRepository(): Repository =
        PersonRepositoryImpl(appDataBase, pagingConfig,Person2PersonEntityMapper(), PersonEntity2PersonMapper())

    val pagingConfig = PagingConfig(
        // 每页显示的数据的大小
        pageSize = 60,

        // 开启占位符
        enablePlaceholders = true,

        // 预刷新的距离，距离最后一个 item 多远时加载数据
        prefetchDistance = 3,

        /**
         * 初始化加载数量，默认为 pageSize * 3
         *
         * internal const val DEFAULT_INITIAL_PAGE_MULTIPLIER = 3
         * val initialLoadSize: Int = pageSize * DEFAULT_INITIAL_PAGE_MULTIPLIER
         */
        initialLoadSize = 60,

        /**
         * 一次应在内存中保存的最大数据
         * 这个数字将会触发，滑动加载更多的数据
         */
        maxSize = 200
    )

}