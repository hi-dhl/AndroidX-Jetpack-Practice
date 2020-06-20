package com.hi.dhl.paging3.network.data.mapper

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 *
 * </pre>
 */
interface Mapper<I, O> {
    fun map(input: I): O
}