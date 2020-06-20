package com.hi.dhl.paging3.network.di

import com.hi.dhl.paging3.network.data.RepositoryFactory
import com.hi.dhl.paging3.network.data.remote.GitHubService
import com.hi.dhl.paging3.network.ui.MainViewModel
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
    viewModel { MainViewModel(get()) }
}

val repoModule = module {
    single { RepositoryFactory(get()).makeGutHubRepository() }
}

val remodeModule = module {
    single { GitHubService.create() }
}

val appModule = listOf(viewModele, repoModule, remodeModule)