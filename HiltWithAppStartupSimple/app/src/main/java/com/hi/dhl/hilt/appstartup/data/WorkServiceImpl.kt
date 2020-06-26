package com.hi.dhl.hilt.appstartup.data

import android.util.Log
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */

/**
 * 注入构造函数，因为Hilt需要知道如何提供 WorkServiceImpl 的实例
 */
class WorkServiceImpl @Inject constructor() :
    WorkService {

    override fun init() {
        Log.e(TAG, " I am an WorkServiceImpl")
    }

    companion object {
        private val TAG = "WorkServiceImpl"
    }
}