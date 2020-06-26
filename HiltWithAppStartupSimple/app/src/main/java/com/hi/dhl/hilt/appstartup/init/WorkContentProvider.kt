package com.hi.dhl.hilt.appstartup.init

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */
class WorkContentProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        context?.run {
            val service = InitializerEntryPoint.resolve(this).injectWorkService()
            Log.e(TAG, "WorkContentProvider ${service.init()}")
        }
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = null


    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun getType(uri: Uri): String? = ""

    companion object {
        private const val TAG = "WorkContentProvider"
    }
}