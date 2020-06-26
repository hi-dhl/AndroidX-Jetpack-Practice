package com.hi.dhl.hilt.appstartup.init

import android.content.Context
import com.hi.dhl.hilt.appstartup.data.WorkService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/25
 *     desc  :
 * </pre>
 */

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface InitializerEntryPoint {

    fun injectWorkService(): WorkService

    companion object {
        fun resolve(context: Context): InitializerEntryPoint {

            val appContext = context.applicationContext ?: throw IllegalStateException()
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java
            )
        }
    }
}