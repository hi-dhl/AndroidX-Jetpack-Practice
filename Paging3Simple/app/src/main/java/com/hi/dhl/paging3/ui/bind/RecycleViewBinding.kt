package com.hi.dhl.paging3.ui.bind

import androidx.databinding.BindingAdapter
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.data.AppExecutors
import com.hi.dhl.paging3.ui.PersonAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */

@BindingAdapter("adapterList")
fun bindAdapterTaskList(recyclerView: RecyclerView, data: Flow<PagingData<Person>>?) {

    requireNotNull(data) {
        throw RuntimeException(" adapter is null")
    }

//    val adapter = recyclerView.adapter as PersonAdapter
//    data.collectLatest { adapter.submitData(it) }
}