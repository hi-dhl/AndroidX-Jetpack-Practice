package com.hi.dhl.hilt.hilt.common.core.remote

import com.hi.dhl.hilt.hilt.common.core.remote.GithubAccountModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */

interface GitHubService {
    @GET("users")
    suspend fun getGithubAccount(@Query("since") id: Int, @Query("per_page") perPage: Int):
            List<GithubAccountModel>
}