package com.hi.dhl.paging3.network.data.remote

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
object ApiGitHub {

//    val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { Log.d("API", it) })
//    logger.level = HttpLoggingInterceptor.Level.BASIC

    val client = OkHttpClient.Builder()
//        .addInterceptor(logger)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService = retrofit.create(GitHubService::class.java)
}