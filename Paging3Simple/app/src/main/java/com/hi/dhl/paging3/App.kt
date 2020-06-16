package com.hi.dhl.paging3

import android.app.Application
import com.hi.dhl.paging3.data.AppExecutors
import com.hi.dhl.paging3.di.appModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModule)
        }
    }
}