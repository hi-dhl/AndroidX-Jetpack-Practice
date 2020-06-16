package com.hi.dhl.paging3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.local.AppDataBase
import com.hi.dhl.paging3.data.local.PersonEntity
import com.hi.dhl.paging3.data.mapper.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 *
 *     1. Repository 执行核心业务逻辑处理（网络、缓存、数据库）
 *     2. 当 Mapping 映射类比较多的时候，可以使用装饰者模式进行封装，
 *
 *     class DataMappersFacade(
 *          val mapper2PersonEntity: Mapper<Person, PersonEntity>,
 *          val mapper2Person: Mapper<PersonEntity, Person>
 *      )
 *
 *      PersonRepositoryImpl(
 *          val db: AppDataBase,
 *          val dataMappersFacade:DataMappersFacade
 *      )
 *
 *      数据映射非常重要的概率，后续会写详细的 Demo 演示
 * </pre>
 */

class PersonRepositoryImpl(
    val db: AppDataBase,
    val pageConfig: PagingConfig,
    val mapper2PersonEntity: Mapper<Person, PersonEntity>,
    val mapper2Person: Mapper<PersonEntity, Person>
) : Repository {

    private val mPersonDao by lazy { db.personDao() }

    override fun postOfData(): Flow<PagingData<Person>> {
        return Pager(pageConfig) {
            // 加载数据库的数据
            mPersonDao.queryAllData()
        }.flow.map { pagingData ->

            // 数据映射，数据库实体 PersonEntity ——>  上层用到的实体 Person
            pagingData.map { mapper2Person.map(it) }
        }
    }

    override fun remove(person: Person) {
        // 数据映射， 上层用到的实体 Person ——> 数据库实体 PersonEntity
        mPersonDao.delete(mapper2PersonEntity.map(person))
    }

    override fun insert(person: Person) {
        // 数据映射， 上层用到的实体 Person ——> 数据库实体 PersonEntity
        mPersonDao.delete(mapper2PersonEntity.map(person))
    }


}