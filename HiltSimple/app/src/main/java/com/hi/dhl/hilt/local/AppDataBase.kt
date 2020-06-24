package com.hi.dhl.paging3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hi.dhl.hilt.BuildConfig

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
