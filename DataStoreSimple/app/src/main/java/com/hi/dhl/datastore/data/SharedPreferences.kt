package com.hi.dhl.datastore.data

import android.content.Context
import android.content.SharedPreferences
import com.hi.dhl.datastore.App

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */
class SharedPreferencesRepository(context: Context) : IRepository {

    val sp = context.getSharedPreferences("ByteCode", Context.MODE_PRIVATE) // 异步加载 SP 文件内容

    override fun saveData(key: String, isChecked: Boolean) {
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putBoolean(key, isChecked)
        editor.apply()
    }

    override fun readData(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

}