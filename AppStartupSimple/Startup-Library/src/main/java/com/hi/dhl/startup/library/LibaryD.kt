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
class LibaryD : Initializer<LibaryD.Dependency> {
    override fun create(context: Context): Dependency {
        // 初始化工作
        Log.e(TAG, "init LibaryD ")
        return Dependency()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

    companion object {
        private const val TAG = "LibaryD";
    }

    class Dependency {

        init {
            initializer = true
        }

        companion object {
            var initializer: Boolean = false
        }
    }
}

