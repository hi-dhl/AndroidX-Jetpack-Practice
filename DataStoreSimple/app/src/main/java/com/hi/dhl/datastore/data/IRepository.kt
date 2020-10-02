package com.hi.dhl.datastore.data

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/10/2
 *     desc  :
 * </pre>
 */
interface IRepository {

    fun saveData(key: String)
    fun readData(key: String): Boolean
}