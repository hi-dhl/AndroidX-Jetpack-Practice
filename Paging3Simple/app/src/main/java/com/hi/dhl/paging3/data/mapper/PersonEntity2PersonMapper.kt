package com.hi.dhl.paging3.data.mapper

import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.local.PersonEntity

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  : 数据映射 ： 数据库实体 PersonEntity ——>  上层用到的实体 Person
 * </pre>
 */
class PersonEntity2PersonMapper : Mapper<PersonEntity, Person> {
    override fun map(input: PersonEntity): Person = Person(input.id, input.name)
}