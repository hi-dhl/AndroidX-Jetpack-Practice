package com.hi.dhl.hilt

import android.util.Log
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/23
 *     desc  :
 * </pre>
 */
class HiltSimple @Inject constructor() {
    fun doSomething() {
        Log.e(TAG, "----doSomething----")
    }

    companion object {
        private val TAG = "HiltSimple"
    }
}