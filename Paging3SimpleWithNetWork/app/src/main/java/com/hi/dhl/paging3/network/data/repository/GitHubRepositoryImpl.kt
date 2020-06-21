package com.hi.dhl.paging3.network.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hi.dhl.paging3.network.bean.GitHubAccount
import com.hi.dhl.paging3.network.data.mapper.Mapper
import com.hi.dhl.paging3.network.data.remote.GitHubService
import com.hi.dhl.paging3.network.data.remote.GithubAccountModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 *
 *     1. Repository 执行核心业务逻辑处理（网络、缓存、数据库）
 *     2. 当 Mapping 映射类比较多的时候，可以使用装饰者模式进行封装，
 *
 *     class DataMappersFacade(
 *          val mapper2PersonEntity: Mapper<Person, PersonEntity>,
 *          val mapper2Person: Mapper<PersonEntity, Person>
 *      )
 *
 *      PersonRepositoryImpl(
 *          val db: AppDataBase,
 *          val dataMappersFacade:DataMappersFacade
 *      )
 *
 *      数据映射非常重要的概念，后续会写详细的 Demo 演示
 * </pre>
 */

class GitHubRepositoryImpl(
    val pageConfig: PagingConfig,
    val gitHubApi: GitHubService,
    val mapper2Person: Mapper<GithubAccountModel, GitHubAccount>
) : Repository {

    override fun postOfData(id: Int): Flow<PagingData<GitHubAccount>> {
        return Pager(pageConfig) {
            // 加载数据库的数据
            GitHubItemPagingSource(gitHubApi)
        }.flow.map { pagingData ->
            // 数据映射，数据源 GithubAccountModel ——>  上层用到的 GitHubAccount
            pagingData.map { mapper2Person.map(it) }
        }
    }
}