package com.hi.dhl.hilt.hilt.module

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hi.dhl.hilt.hilt.feature.task.Repository

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */
class HiltViewModel @ViewModelInject constructor(
    private val tasksRepository: Repository,
    //SavedStateHandle 用于进程被终止时，存储和恢复数据
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun insert() {
        tasksRepository.updateData("dhl")
    }

    companion object {
        private val USER_KEY = "userId"
    }
}