package com.hi.dhl.paging3.network.data.remote

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
interface GitHubService {

    @GET("users")
    suspend fun getGithubAccount(@Query("since") id: Int, @Query("per_page") perPage: Int):
            List<GithubAccountModel>
}