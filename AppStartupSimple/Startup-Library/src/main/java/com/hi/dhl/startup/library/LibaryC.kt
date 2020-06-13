package com.hi.dhl.startup.library

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/13
 *     desc  :
 * </pre>
 */
class LibaryC : Initializer<LibaryC.Dependency> {
    override fun create(context: Context): Dependency {
        // 初始化工作
        Log.e(TAG, "init LibaryC ")
        return Dependency()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(LibaryB::class.java)
    }

    companion object {
        private const val TAG = "LibaryC";
    }

    class Dependency {

    }
}

