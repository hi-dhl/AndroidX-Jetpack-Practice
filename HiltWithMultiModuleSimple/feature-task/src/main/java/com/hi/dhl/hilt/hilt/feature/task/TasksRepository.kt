package com.hi.dhl.hilt.hilt.feature.task

import com.hi.dhl.hilt.hilt.common.core.DataSource
import com.hi.dhl.hilt.hilt.common.core.local.PersonEntity
import com.hi.dhl.hilt.hilt.feature.task.AppExecutors
import com.hi.dhl.hilt.hilt.feature.task.Repository
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */
class TasksRepository @Inject constructor(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource
) : Repository {
    override fun updateData(name: String) {
        AppExecutors.disIO {
            val person = PersonEntity(
                name = "dhl",
                updateTime = System.currentTimeMillis()
            )
            localDataSource.saveTask(person)
            remoteDataSource.saveTask(person)
        }
    }
}