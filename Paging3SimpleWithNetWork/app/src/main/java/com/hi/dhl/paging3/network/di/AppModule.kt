package com.hi.dhl.paging3.network.di

import com.hi.dhl.paging3.network.data.RepositoryFactory
import com.hi.dhl.paging3.network.data.local.AppDataBase
import com.hi.dhl.paging3.network.data.remote.ApiGitHub
import com.hi.dhl.paging3.network.data.remote.ZhihuService
import com.hi.dhl.paging3.network.ui.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */

val viewModele = module {
    viewModel { MainViewModel(get(),get()) }
}

val localModule = module {
    single { AppDataBase.initDataBase(androidApplication()) }
}

val repoModule = module {
    single { RepositoryFactory(get(), get(),get()).makeGutHubRepository() }
    single { RepositoryFactory(get(), get(),get()).makeZhihuRepository() }
}

val remodeModule = module {
    single { api }
    single { ZhihuService.create() }
}

val api = ApiGitHub.gitHubService
val appModule = listOf(viewModele, localModule, repoModule, remodeModule)