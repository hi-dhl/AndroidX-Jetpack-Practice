package com.hi.dhl.datastore.ui

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hi.dhl.datastore.data.IDataStoreRepository
import com.hi.dhl.datastore.data.IRepository
import com.hi.dhl.datastore.data.ProtoDataStoreRepository
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */
class MainViewModel @ViewModelInject constructor(
    private val spRepo: IRepository,
    private val dataStoreRepo: IDataStoreRepository,
    private val protoDataStoreRepo: ProtoDataStoreRepository
) : ViewModel() {

    // 使用 SharedPreferences
    fun saveData(key: String) = spRepo.saveData(key)
    fun getData(key: String) = spRepo.readData(key)

    //-------------------------------------

    // 使用 Preferences DataStore
    fun saveDataByDataStore(key: Preferences.Key<Boolean>) {
        viewModelScope.launch {
            dataStoreRepo.saveData(key)
        }
    }

    fun getDataStore(key: Preferences.Key<Boolean>) = dataStoreRepo.readData(key).asLiveData()

    // 合并 SharedPreferences to datastore-preferences
    fun migrationSP2DataStore() = dataStoreRepo.migrationSP2DataStore()
    fun testMigration(key: Preferences.Key<Boolean>) = dataStoreRepo.readData(key)


    //--------------------------------

    // 使用 Proto DataStore
    fun getProtoDataStoreForPerson() = protoDataStoreRepo.readData().asLiveData()
    fun saveProtoDataStoreForPerson(personModel: PersonModel) {
        viewModelScope.launch {
            protoDataStoreRepo.saveData(personModel)
        }
    }

    fun migrationSP2ProtoDataStore() = protoDataStoreRepo.migrationSP2DataStore()
}

object PreferencesKeys {
    // SharedPreferences 的测试的 key
    val KEY_ACCOUNT = "ByteCode"

    // DataStore 的测试的 key
    val KEY_BYTE_CODE = booleanPreferencesKey("ByteCode")
    val KEY_WEI_BO = booleanPreferencesKey("weibo")
    val KEY_GITHUB = booleanPreferencesKey("GitHub")
}