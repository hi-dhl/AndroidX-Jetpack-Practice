package com.hi.dhl.paging3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.RepositoryFactory

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
class MainViewModel(factory: RepositoryFactory) : ViewModel() {

    // 对内访问，支持修改
//    private val _pageDataLiveData: MutableLiveData<PagingData<Person>> by lazy { MutableLiveData() }

    // 对外访问只能查看
//    val pageDataLiveData: LiveData<PagingData<Person>> = _pageDataLiveData

    init {
        factory.makeLocalRepository().getAllData()
    }
}