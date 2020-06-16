package com.hi.dhl.paging3.ui

import android.view.View
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.hi.dhl.paging3.bean.Person
import com.hi.dhl.paging3.databinding.RecycieItemPersonBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
class PersonViewHolder(view: View) : DataBindingViewHolder<Person>(view) {
    val mBinding: RecycieItemPersonBinding by viewHolderBinding(view)
    override fun bindData(data: Person, position: Int) {
        mBinding.apply {
            person = data
            executePendingBindings()
        }
    }
}