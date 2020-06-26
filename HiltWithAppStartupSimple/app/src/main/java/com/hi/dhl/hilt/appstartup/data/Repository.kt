package com.hi.dhl.hilt.appstartup.data

import com.hi.dhl.hilt.appstartup.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/26
 *     desc  :
 * </pre>
 */
interface Repository {
    fun updateData(person: PersonEntity)
}