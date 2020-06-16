package com.hi.dhl.paging3.data

import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.mapper.PersonDataMapper
import com.hi.dhl.paging3.data.repository.LocalRepositoryImpl
import com.hi.dhl.paging3.data.repository.Repository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  : 工厂模式 , 用到 koin 的依赖注入, 隐藏了 Repository 和  Mapper 显示的依赖关系
 * </pre>
 */

class RepositoryFactory(val appDataBase: AppDataBase) {

    fun makeLocalRepository(): Repository = LocalRepositoryImpl(appDataBase, PersonDataMapper())

}