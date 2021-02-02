package com.hi.dhl.datastore.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.*
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 *
 *     DataStore 文件存放目录: /data/data/<包名>/files/datastore
 *     hi-dhl 的公众号：ByteCode
 *
 * </pre>
 */


class DataStoreRepository(val context: Context) : IDataStoreRepository {

    private val PREFERENCE_NAME = "DataStore"
    var dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_NAME
    )


    override fun migrationSP2DataStore() {
        /**
         *  传入 migrations 参数，构建一个 DataStore 之后，
         *  需要执行 一次读取 或者 写入，DataStore 才会自动合并 SharedPreference 文件内容
         */
        dataStore = context.createDataStore(
            name = PREFERENCE_NAME,
            migrations = listOf(
                SharedPreferencesMigration(
                    context,
                    SharedPreferencesRepository.PREFERENCE_NAME
                )
            )
        )
    }

    override suspend fun saveData(key: Preferences.Key<Boolean>) {
        dataStore.edit { mutablePreferences ->
            val value = mutablePreferences[key] ?: false
            mutablePreferences[key] = !value
        }
    }

    override fun readData(key: Preferences.Key<Boolean>): Flow<Boolean> =
        dataStore.data
            .catch {
                // 当读取数据遇到错误时，如果是 `IOException` 异常，发送一个 emptyPreferences，来重新使用
                // 但是如果是其他的异常，最好将它抛出去，不要隐藏问题
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map { preferences ->
                preferences[key] ?: false
            }
}