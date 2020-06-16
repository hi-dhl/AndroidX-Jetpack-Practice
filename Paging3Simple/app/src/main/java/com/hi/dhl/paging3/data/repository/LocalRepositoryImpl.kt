package com.hi.dhl.paging3.data.repository

import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.local.PersonEntity
import com.hi.dhl.paging3.data.mapper.Mapper

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
class LocalRepositoryImpl(val db: AppDataBase, mapper: Mapper<PersonEntity, Person>) : Repository {
    override fun getAllData() = db.personDao().queryAllData()
}