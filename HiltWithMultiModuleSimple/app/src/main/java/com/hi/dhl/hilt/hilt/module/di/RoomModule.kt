package com.hi.dhl.hilt.hilt.module.di

import android.app.Application
import androidx.room.Room
import com.hi.dhl.hilt.hilt.common.core.local.AppDataBase
import com.hi.dhl.hilt.hilt.common.core.local.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */

@Module
@InstallIn(ApplicationComponent::class)
// 这里使用了 ApplicationComponent，因此 RoomModule 绑定到 Application 的生命周期。
object RoomModule {

    /**
     * @Provides 常用于被 @Module 注解标记类的内部的方法，并提供依赖项对象。
     * @Singleton 提供单例
     */
    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): AppDataBase {
        return Room
            .databaseBuilder(application, AppDataBase::class.java, "dhl.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providePersonDao(appDatabase: AppDataBase): PersonDao {
        return appDatabase.personDao()
    }
}
