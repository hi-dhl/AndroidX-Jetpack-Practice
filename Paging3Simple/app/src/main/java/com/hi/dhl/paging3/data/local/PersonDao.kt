package com.hi.dhl.paging3.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */

@Dao
interface PersonDao {

    @Query("SELECT * FROM PersonEntity")
    fun queryAllData(): PagingSource<Int, PersonEntity>

    @Insert
    fun insert(personEntity: List<PersonEntity>)

    @Delete
    fun delete(personEntity: PersonEntity)
}