package com.hi.dhl.datastore.di

import android.content.Context
import com.hi.dhl.datastore.data.IRepository
import com.hi.dhl.datastore.data.SharedPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext ctx: Context): IRepository {
        return SharedPreferencesRepository(ctx)
    }
}