package com.hi.dhl.hilt.appstartup.init

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/25
 *     desc  :
 * </pre>
 */

class AppInitializer : Initializer<Unit> {


    override fun create(context: Context): Unit {
        val service = InitializerEntryPoint.resolve(context).injectWorkService()
        Log.e(TAG, "AppInitializer ${service.init()}")
        return Unit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> =
        mutableListOf()

    companion object {
        private val TAG = "AppInitializer"
    }
}