package com.hi.dhl.hilt.appstartup.di

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */

@Singleton
class HiltSimple @Inject constructor() {
    fun doSomething() {
        Log.e(TAG, "----doSomething----")
    }

    companion object {
        private val TAG = "HiltSimple"
    }
}