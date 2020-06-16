package com.hi.dhl.paging3.ui

import androidx.lifecycle.*
import androidx.paging.PagingData
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.AppExecutors
import com.hi.dhl.paging3.data.repository.Repository
import kotlinx.coroutines.flow.Flow

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
class MainViewModel(val repository: Repository) : ViewModel() {

    /**
     * 方法一
     * 在 LifeCycle 2.2.0 之前使用的方法，但是这种方式过去复杂
     * 在 LifeCycle 2.2.0 之后，可以用更精简的方法来完成
     */

    // 私有的 MutableLiveData，对内访问
    private val _pageDataLiveData: MutableLiveData<Flow<PagingData<Person>>>
            by lazy { MutableLiveData<Flow<PagingData<Person>>>() }

    // 对外暴露不可变的 LiveData，只能查询
    val pageDataLiveData: LiveData<Flow<PagingData<Person>>> = _pageDataLiveData

    init {
        _pageDataLiveData.postValue(repository.postOfData())
    }

    /**
     * 方法二
     *
     * LifeCycle 2.2.0 之后，使用 LiveData 协程构造方法 (coroutine builder)
     * liveData 协程构造方法提供了一个协程代码块，产生的是一个不可变的 LiveData，emit() 方法则用来更新 LiveData 的数据。
     */
    val pageDataLiveData2 = liveData {
        emit(repository.postOfData())
    }

    /**
     *
     * 方法三
     *
     * 在项目里面，我们使用的是 Flow， 所以方法更加简单，一行代码就搞定了
     */
    val pageDataLiveData3: LiveData<PagingData<Person>> = repository.postOfData().asLiveData()


    //-------------------方法四-------------
    fun postOfPerson() = repository.postOfData()

    fun remove(person: Person) {
        AppExecutors.disIO {
            // 当数据源变化的时候，自动更新 ui
            repository.remove(person)
        }
    }

    fun insert(person: Person) {
        AppExecutors.disIO {
            // 当数据源变化的时候，自动更新 ui
            repository.insert(person)
        }
    }
}