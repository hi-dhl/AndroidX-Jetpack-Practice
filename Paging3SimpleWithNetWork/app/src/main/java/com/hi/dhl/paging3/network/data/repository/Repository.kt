package com.hi.dhl.paging3.network.data.repository

import androidx.paging.PagingData
import com.hi.dhl.paging3.network.bean.GitHubAccount
import com.hi.dhl.paging3.network.data.remote.ZhihuNewsModel
import kotlinx.coroutines.flow.Flow
import org.jetbrains.anko.AnkoLogger

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
interface Repository : AnkoLogger {

    fun postOfData(id: Int): Flow<PagingData<GitHubAccount>>

}