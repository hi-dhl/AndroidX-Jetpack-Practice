package com.hi.dhl.hilt.ui

import com.hi.dhl.hilt.di.HiltSimple
import com.hi.dhl.paging3.data.local.PersonDao
import com.hi.dhl.paging3.data.local.PersonEntity
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/8/6
 *     desc  :
 * </pre>
 */
class Utils @Inject constructor(){
    // 使用 @Inject 注解从组件中获取依赖
    @Inject
    lateinit var  personDao: PersonDao
    fun println(){
        personDao.insert(PersonEntity(name = "dhl", updateTime = System.currentTimeMillis()))
    }
}