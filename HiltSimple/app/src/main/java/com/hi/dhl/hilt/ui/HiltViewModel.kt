package com.hi.dhl.hilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */
class HiltViewModel @ViewModelInject constructor(
    val db: AppDataBase
) : ViewModel() {

    /**
     * 在 LifeCycle 2.2.0 之后，可以用更精简的方法来完成，使用 LiveData 协程构造方法 (coroutine builder)。
     * liveData 协程构造方法提供了一个协程代码块，产生的是一个不可变的 LiveData，emit() 方法则用来更新 LiveData 的数据。
     *
     * 具体可以查看之前写的这篇文章 [https://juejin.im/post/5ee998e8e51d4573d65df02b#heading-10] 有详细介绍
     */
    val mHitLiveData = liveData {
        emit("i am a ViewModelInject")
    }


    fun insert() {
        AppExecutors.disIO {
            db.personDao().insert(PersonEntity(name = "dhl", updateTime = System.currentTimeMillis()))
        }
    }
}