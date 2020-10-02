package com.hi.dhl.datastore.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.hi.dhl.datastore.data.IRepository
import com.hi.dhl.datastore.data.SharedPreferencesRepository
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */
class MainViewModel @ViewModelInject constructor(
    private val spRepo: IRepository
) : ViewModel() {

    fun saveData(key: String, isChecked: Boolean) = spRepo.saveData(key, isChecked)
    fun getData(key: String) = spRepo.readData(key)
}