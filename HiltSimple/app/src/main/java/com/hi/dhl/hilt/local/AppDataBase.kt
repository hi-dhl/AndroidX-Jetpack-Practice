package com.hi.dhl.paging3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */

@Database(
    entities = arrayOf(PersonEntity::class),
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao
}
