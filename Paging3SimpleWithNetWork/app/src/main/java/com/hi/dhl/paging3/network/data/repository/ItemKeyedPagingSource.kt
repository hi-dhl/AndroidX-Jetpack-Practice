package com.hi.dhl.paging3.network.data.repository

import androidx.paging.PagingSource
import com.hi.dhl.paging3.network.data.remote.GitHubService
import com.hi.dhl.paging3.network.data.remote.GithubAccountModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
class ItemKeyedPagingSource(
    private val gitHubApi: GitHubService,
    private val id: Int
) : PagingSource<Int, GithubAccountModel>(), AnkoLogger {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubAccountModel> {
        val key = params.key ?: 0

        return try {
            error { "key = ${key}" }
            val items = gitHubApi.getGithubAccount(key, params.loadSize)
            LoadResult.Page(
                data = items,
                prevKey = null,
                nextKey = items.lastOrNull()?.id
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
//
//    @OptIn(ExperimentalPagingApi::class)
//    override fun getRefreshKey(state: PagingState<Int, GithubAccountModel>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestItemToPosition(anchorPosition)?.id
//        }
//    }

}