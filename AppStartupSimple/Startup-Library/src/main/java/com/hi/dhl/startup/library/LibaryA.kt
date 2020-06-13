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
class LibaryA : Initializer<LibaryA.Dependency> {
    override fun create(context: Context): Dependency {
        // 初始化工作
        Log.e(TAG, "init LibaryA ")
        return Dependency()
    }

    override fun dependencies(): MutableList<Class<Initializer<*>>> {
        return mutableListOf()
    }

    companion object {
        private const val TAG = "LibaryA";
    }

    class Dependency {

    }
}

