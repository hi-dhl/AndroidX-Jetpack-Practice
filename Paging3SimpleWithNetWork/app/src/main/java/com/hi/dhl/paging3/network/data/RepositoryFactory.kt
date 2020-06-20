package com.hi.dhl.paging3.network.data

import androidx.paging.PagingConfig
import com.hi.dhl.paging3.network.data.mapper.Model2GitHubMapper
import com.hi.dhl.paging3.network.data.remote.GitHubService
import com.hi.dhl.paging3.network.data.repository.GitHubRepositoryImpl
import com.hi.dhl.paging3.network.data.repository.Repository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  : 用到 koin 的依赖注入 , 上层不需要关心 Repository 和  Mapper，隐藏了 Repository 和  Mapper 显示的依赖关系
 * </pre>
 */

class RepositoryFactory(
    val gitHubApi: GitHubService
) {

    // 传递 PagingConfig 和 Data Mapper
    fun makeGutHubRepository(): Repository =
        GitHubRepositoryImpl(
            pagingConfig,
            gitHubApi, Model2GitHubMapper()
        )

    val pagingConfig = PagingConfig(
        // 每页显示的数据的大小
        pageSize = 30,

        // 开启占位符
        enablePlaceholders = false

        // 预刷新的距离，距离最后一个 item 多远时加载数据
//        prefetchDistance = 3,

        /**
         * 初始化加载数量，默认为 pageSize * 3
         *
         * internal const val DEFAULT_INITIAL_PAGE_MULTIPLIER = 3
         * val initialLoadSize: Int = pageSize * DEFAULT_INITIAL_PAGE_MULTIPLIER
         */
//        initialLoadSize = 60
    )

}