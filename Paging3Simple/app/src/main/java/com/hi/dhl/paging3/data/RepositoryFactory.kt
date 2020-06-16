package com.hi.dhl.paging3.data

import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.mapper.PersonEntity2PersonMapper
import com.hi.dhl.paging3.data.mapper.Person2PersonEntityMapper
import com.hi.dhl.paging3.data.repository.PersonRepositoryImpl
import com.hi.dhl.paging3.data.repository.Repository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  : 用到 koin 的依赖注入, 上层不需要关心 Repository 和  Mapper，隐藏了 Repository 和  Mapper 显示的依赖关系
 * </pre>
 */

class RepositoryFactory(val appDataBase: AppDataBase) {

    fun makeLocalRepository(): Repository =
        PersonRepositoryImpl(appDataBase, Person2PersonEntityMapper(), PersonEntity2PersonMapper())

}