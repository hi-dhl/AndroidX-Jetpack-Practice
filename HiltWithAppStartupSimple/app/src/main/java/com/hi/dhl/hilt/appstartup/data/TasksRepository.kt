package com.hi.dhl.hilt.appstartup.data

import com.hi.dhl.hilt.appstartup.data.local.PersonEntity
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */
class TasksRepository @Inject constructor(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource
) : Repository {
    override fun updateData(person: PersonEntity) {
        AppExecutors.disIO {
            localDataSource.saveTask(person)
            remoteDataSource.saveTask(person)
        }
    }
}