package com.hi.dhl.startup.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/13
 *     desc  :
 * </pre>
 */
class WorkContentProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        Log.d(TAG, "WorkContentProvider create()")
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