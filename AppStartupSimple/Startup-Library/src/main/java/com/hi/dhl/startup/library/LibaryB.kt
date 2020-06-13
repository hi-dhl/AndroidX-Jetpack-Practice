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
class LibaryB : Initializer<LibaryB.Dependency> {
    override fun create(context: Context): Dependency {
        // 初始化工作
        Log.e(TAG, "init LibaryB ")
        return Dependency()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(LibaryA::class.java)
    }

    companion object {
        private const val TAG = "LibaryB";
    }

    class Dependency {

    }
}

