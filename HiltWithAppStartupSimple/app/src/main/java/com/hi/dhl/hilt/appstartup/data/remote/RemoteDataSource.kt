package com.hi.dhl.hilt.appstartup.data.remote

import android.util.ArrayMap
import com.hi.dhl.hilt.appstartup.data.DataSource
import com.hi.dhl.hilt.appstartup.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */
class RemoteDataSource : DataSource {
    val mData = ArrayMap<Int, PersonEntity>()
    override fun saveTask(person: PersonEntity) {
        mData.put(person.id, person)
    }
}