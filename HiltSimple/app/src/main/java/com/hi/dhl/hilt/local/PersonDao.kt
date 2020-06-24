package com.hi.dhl.paging3.data.local

import androidx.paging.PagingSource
import androidx.room.*

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */

@Dao
interface PersonDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(personEntity: PersonEntity)

}