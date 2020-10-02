package com.hi.dhl.datastore.data

import androidx.datastore.preferences.Preferences
import kotlinx.coroutines.flow.Flow


/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */
interface IDataStoreRepository  {
    suspend fun saveData(key: Preferences.Key<Boolean>)

    fun readData(key: Preferences.Key<Boolean>): Flow<Boolean>

    fun migrationSP2DataStore()
}