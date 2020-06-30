package com.hi.dhl.hilt.hilt.common.core.local

import com.hi.dhl.hilt.hilt.common.core.DataSource

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */
class LocalDataSource(private val personDao: PersonDao) :
    DataSource {
    override fun saveTask(person: PersonEntity) {
        personDao.insert(person)
    }
}