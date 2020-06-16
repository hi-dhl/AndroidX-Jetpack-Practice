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
 * </pre>
 */
class PersonRepositoryImpl(
    val db: AppDataBase,
    val mapper2PersonEntity: Mapper<Person,PersonEntity>,
    val mapper2Person: Mapper<PersonEntity, Person>
) : Repository {

    override fun postOfData(): Flow<PagingData<Person>> {
        return Pager(
            PagingConfig(
                /**
                 * A good page size is a value that fills at least a few screens worth of content on a
                 * large device so the User is unlikely to see a null item.
                 * You can play with this constant to observe the paging behavior.
                 *
                 * It's possible to vary this with list device size, but often unnecessary, unless a
                 * user scrolling on a large device is expected to scroll through items more quickly
                 * than a small device, such as when the large device uses a grid layout of items.
                 */
                /**
                 * A good page size is a value that fills at least a few screens worth of content on a
                 * large device so the User is unlikely to see a null item.
                 * You can play with this constant to observe the paging behavior.
                 *
                 * It's possible to vary this with list device size, but often unnecessary, unless a
                 * user scrolling on a large device is expected to scroll through items more quickly
                 * than a small device, such as when the large device uses a grid layout of items.
                 */
                /**
                 * A good page size is a value that fills at least a few screens worth of content on a
                 * large device so the User is unlikely to see a null item.
                 * You can play with this constant to observe the paging behavior.
                 *
                 * It's possible to vary this with list device size, but often unnecessary, unless a
                 * user scrolling on a large device is expected to scroll through items more quickly
                 * than a small device, such as when the large device uses a grid layout of items.
                 */
                /**
                 * A good page size is a value that fills at least a few screens worth of content on a
                 * large device so the User is unlikely to see a null item.
                 * You can play with this constant to observe the paging behavior.
                 *
                 * It's possible to vary this with list device size, but often unnecessary, unless a
                 * user scrolling on a large device is expected to scroll through items more quickly
                 * than a small device, such as when the large device uses a grid layout of items.
                 */
                pageSize = 60,

                /**
                 * If placeholders are enabled, PagedList will report the full size but some items might
                 * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
                 *
                 * If placeholders are disabled, onBind will never receive null but as more pages are
                 * loaded, the scrollbars will jitter as new pages are loaded. You should probably
                 * disable scrollbars if you disable placeholders.
                 */

                /**
                 * If placeholders are enabled, PagedList will report the full size but some items might
                 * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
                 *
                 * If placeholders are disabled, onBind will never receive null but as more pages are
                 * loaded, the scrollbars will jitter as new pages are loaded. You should probably
                 * disable scrollbars if you disable placeholders.
                 */

                /**
                 * If placeholders are enabled, PagedList will report the full size but some items might
                 * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
                 *
                 * If placeholders are disabled, onBind will never receive null but as more pages are
                 * loaded, the scrollbars will jitter as new pages are loaded. You should probably
                 * disable scrollbars if you disable placeholders.
                 */

                /**
                 * If placeholders are enabled, PagedList will report the full size but some items might
                 * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
                 *
                 * If placeholders are disabled, onBind will never receive null but as more pages are
                 * loaded, the scrollbars will jitter as new pages are loaded. You should probably
                 * disable scrollbars if you disable placeholders.
                 */
                enablePlaceholders = true,

                /**
                 * Maximum number of items a PagedList should hold in memory at once.
                 *
                 * This number triggers the PagedList to start dropping distant pages as more are loaded.
                 */

                /**
                 * Maximum number of items a PagedList should hold in memory at once.
                 *
                 * This number triggers the PagedList to start dropping distant pages as more are loaded.
                 */

                /**
                 * Maximum number of items a PagedList should hold in memory at once.
                 *
                 * This number triggers the PagedList to start dropping distant pages as more are loaded.
                 */

                /**
                 * Maximum number of items a PagedList should hold in memory at once.
                 *
                 * This number triggers the PagedList to start dropping distant pages as more are loaded.
                 */
                maxSize = 200
            )
        ) {
            db.personDao().queryAllData()
        }.flow.map { pagingData -> pagingData.map { mapper2Person.map(it) } }
    }

    override fun remove(person: Person) {
        db.personDao().delete(mapper2PersonEntity.map(person))
    }

    override fun insert(person: Person) {
        db.personDao().delete(mapper2PersonEntity.map(person))
    }


}