package com.hi.dhl.hilt.appstartup.di

import com.hi.dhl.hilt.appstartup.data.DataSource
import com.hi.dhl.hilt.appstartup.data.Repository
import com.hi.dhl.hilt.appstartup.data.TasksRepository
import com.hi.dhl.hilt.appstartup.data.local.AppDataBase
import com.hi.dhl.hilt.appstartup.data.local.LocalDataSource
import com.hi.dhl.hilt.appstartup.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */

@Module
@InstallIn(ApplicationComponent::class)
object QualifierModule {

    // 为每个声明的限定符，提供对应的类型实例，和 @Binds 或者 @Provides 一起使用
    @Qualifier
    // @Retention 定义了注解的生命周期，对应三个值（SOURCE、BINARY、RUNTIME）
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteTasksDataSource // 注解的名字，后面直接使用它

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalTasksDataSource

    @Singleton
    @RemoteTasksDataSource
    @Provides
    fun provideTasksRemoteDataSource(): DataSource { // 返回值相同
        return RemoteDataSource() // 不同的实现
    }

    @Singleton
    @LocalTasksDataSource
    @Provides
    fun provideTaskLocalDataSource(appDatabase: AppDataBase): DataSource { // 返回值相同
        return LocalDataSource(appDatabase.personDao()) // 不同的实现
    }

    @Singleton
    @Provides
    fun provideTasksRepository(
        @LocalTasksDataSource localDataSource: DataSource,
        @RemoteTasksDataSource remoteDataSource: DataSource
    ): Repository {
        return TasksRepository(
            localDataSource,
            remoteDataSource
        )
    }
}