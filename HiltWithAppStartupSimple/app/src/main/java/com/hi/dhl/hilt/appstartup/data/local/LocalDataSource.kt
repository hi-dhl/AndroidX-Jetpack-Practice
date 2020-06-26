package com.hi.dhl.hilt.appstartup.data.local

import com.hi.dhl.hilt.appstartup.data.DataSource

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */
class LocalDataSource(private val personDao: PersonDao) :
    DataSource {
    override fun saveTask(person: PersonEntity) {
        personDao.insert(person)
    }
}