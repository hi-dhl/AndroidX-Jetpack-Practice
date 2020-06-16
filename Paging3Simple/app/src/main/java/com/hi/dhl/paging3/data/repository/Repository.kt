package com.hi.dhl.paging3.data.repository

import androidx.paging.PagingData
import com.hi.dhl.paging3.bean.Person
import kotlinx.coroutines.flow.Flow

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
interface Repository {

    fun postOfData(): Flow<PagingData<Person>>

    fun remove(person: Person)

    fun insert(person: Person)
}