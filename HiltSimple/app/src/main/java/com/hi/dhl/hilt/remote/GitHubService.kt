package com.hi.dhl.hilt.remote

import com.hi.dhl.hilt.remote.GithubAccountModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */

interface GitHubService {
    @GET("users")
    suspend fun getGithubAccount(@Query("since") id: Int, @Query("per_page") perPage: Int):
            List<GithubAccountModel>
}