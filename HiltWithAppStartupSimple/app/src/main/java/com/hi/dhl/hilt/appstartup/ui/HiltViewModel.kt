package com.hi.dhl.hilt.appstartup.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hi.dhl.hilt.appstartup.data.Repository
import com.hi.dhl.hilt.appstartup.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */
class HiltViewModel @ViewModelInject constructor(
    private val tasksRepository: Repository,
    //SavedStateHandle 用于进程被终止时，存储和恢复数据
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // getLiveData 方法会取得一个与 key 相关联的 MutableLiveData
    // 当与 key 相对应的 value 改变时 MutableLiveData 也会更新。
    private val _userId: MutableLiveData<String> = savedStateHandle.getLiveData(USER_KEY)

    // 对外暴露不可变的 LiveData
    val userId: LiveData<String> = _userId


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
        tasksRepository.updateData(
            PersonEntity(
                name = "dhl",
                updateTime = System.currentTimeMillis()
            )
        )
    }

    companion object {
        private val USER_KEY = "userId"
    }
}