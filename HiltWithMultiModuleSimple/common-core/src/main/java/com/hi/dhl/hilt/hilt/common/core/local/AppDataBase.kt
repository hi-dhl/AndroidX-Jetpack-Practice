package com.hi.dhl.hilt.hilt.common.core.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
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
