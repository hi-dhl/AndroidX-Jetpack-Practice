package com.hi.dhl.paging3.data.mapper

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
interface Mapper<I, O> {
    fun map(input: I): O
}