package com.hi.dhl.paging3.network.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.hi.dhl.paging3.network.bean.GitHubAccount
import com.hi.dhl.paging3.network.data.repository.Repository
import com.hi.dhl.paging3.network.data.repository.ZhihuRepository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
class MainViewModel(val repository: Repository, val zhihuRepository: ZhihuRepository) :
    ViewModel() {


    /**
     * 我们使用的是 Flow，调用 Flow 的 asLiveData 方法转为 LiveData
     */
    val gitHubLiveData: LiveData<PagingData<GitHubAccount>> =
        repository.postOfData(0).asLiveData()

    val zhihuDataLiveData = zhihuRepository.postOfZhihuData().asLiveData()

//        zhihuRepository.postOfZhihuData().asLiveData()

}