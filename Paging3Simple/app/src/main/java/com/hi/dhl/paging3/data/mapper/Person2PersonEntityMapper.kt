package com.hi.dhl.paging3.data.mapper

import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  : 数据映射 ： 上层用到的实体 Person ——> 数据库实体 PersonEntity
 * </pre>
 */
class Person2PersonEntityMapper : Mapper<Person, PersonEntity> {
    override fun map(input: Person): PersonEntity = PersonEntity(input.id, input.name)
}