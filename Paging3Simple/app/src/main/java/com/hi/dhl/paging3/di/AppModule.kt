package com.hi.dhl.paging3.di

import com.hi.dhl.paging3.data.RepositoryFactory
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.remote.UserService
import com.hi.dhl.paging3.ui.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */

val viewModele = module {
    viewModel { MainViewModel(get()) }
}

val localModule = module {
    single { AppDataBase.initDataBase(androidApplication()) }
}

val remoteModule = module {
    single<Retrofit> {
        Retrofit.Builder()
//                .baseUrl(Constants.HOST_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<UserService> { get<Retrofit>().create(UserService::class.java) }
}

val repoModule = module {
    single { RepositoryFactory(get()) }
}

val appModule = listOf(viewModele, localModule, repoModule)