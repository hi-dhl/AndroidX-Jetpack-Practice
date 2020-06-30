package com.hi.dhl.hilt.hilt.common.core

import com.hi.dhl.hilt.hilt.common.core.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/30
 *     desc  :
 * </pre>
 */
public interface DataSource {
    fun saveTask(person: PersonEntity)
}