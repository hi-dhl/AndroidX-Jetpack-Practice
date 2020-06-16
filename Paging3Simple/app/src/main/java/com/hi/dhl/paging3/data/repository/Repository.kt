package com.hi.dhl.paging3.data.repository

import androidx.paging.PagingSource
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
interface Repository {
    fun getAllData():PagingSource<Int, PersonEntity>
}