package com.hi.dhl.paging3.network.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hi.dhl.paging3.network.BuildConfig

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */

@Database(
    entities = arrayOf(PersonEntity::class),
    version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        val DB_NAME = "dhl"
        private var instance: AppDataBase? = null

        @Synchronized
        fun initDataBase(context: Context): AppDataBase? {
            if (instance == null) {
                val model = if (BuildConfig.DEBUG) RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING
                else RoomDatabase.JournalMode.AUTOMATIC
                instance = Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME)
                    .setJournalMode(model)
                    .build()
            }
            return instance
        }

    }

}