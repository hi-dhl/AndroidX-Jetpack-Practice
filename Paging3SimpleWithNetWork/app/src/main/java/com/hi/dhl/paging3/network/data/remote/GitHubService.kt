package com.hi.dhl.paging3.network.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

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

    companion object {
        fun create(): GitHubService {
            val client = OkHttpClient.Builder()
                .build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GitHubService::class.java)
        }
    }
}