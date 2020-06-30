package com.hi.dhl.hilt.hilt.common.core.remote

import android.util.ArrayMap
import com.hi.dhl.hilt.hilt.common.core.DataSource
import com.hi.dhl.hilt.hilt.common.core.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */
class RemoteDataSource : DataSource {
    val mData = ArrayMap<Int, PersonEntity>()
    override fun saveTask(person: PersonEntity) {
        mData.put(person.id, person)
    }
}