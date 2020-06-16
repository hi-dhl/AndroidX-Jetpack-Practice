package com.hi.dhl.paging3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import com.hi.dhl.jdatabinding.dowithTry
import com.hi.dhl.paging3.R
import com.hi.dhl.paging3.bean.Person

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */

class PersonAdapter : PagingDataAdapter<Person, PersonViewHolder>(Person.diffCallback) {

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        dowithTry {
            val data = getItem(position)
            data?.let {
                holder.bindData(it, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = inflateView(parent, R.layout.recycie_item_person)
        return PersonViewHolder(view)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}