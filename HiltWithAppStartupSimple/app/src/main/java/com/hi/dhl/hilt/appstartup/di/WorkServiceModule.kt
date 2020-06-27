package com.hi.dhl.hilt.appstartup.di

import com.hi.dhl.hilt.appstartup.data.WorkService
import com.hi.dhl.hilt.appstartup.data.WorkServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */

@Module
@InstallIn(ApplicationComponent::class)
// 这里使用了 ActivityComponent，因此 WorkServiceModule 绑定到 ActivityComponent 的生命周期。
abstract class WorkServiceModule {

    /**
     * @Binds 注解告诉 Hilt 需要提供接口实例时使用哪个实现
     *
     * bindAnalyticsService 函数需要为 Hilt 提供了以下信息
     *      1. 函数返回类型告诉 Hilt 提供了哪个接口的实例
     *      2. 函数参数告诉 Hilt 提供哪个实现
     */
    @Binds
    abstract fun bindAnalyticsService(
        workServiceImpl: WorkServiceImpl
    ): WorkService
}