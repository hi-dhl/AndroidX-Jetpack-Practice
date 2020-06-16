package com.hi.dhl.paging3.di

import com.hi.dhl.paging3.data.RepositoryFactory
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.ui.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

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

val repoModule = module {
    single { RepositoryFactory(get()).makeLocalRepository() }
}

val appModule = listOf(viewModele, localModule, repoModule)