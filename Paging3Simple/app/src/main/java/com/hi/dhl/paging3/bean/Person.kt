package com.hi.dhl.paging3.bean

import androidx.recyclerview.widget.DiffUtil
import java.util.jar.Attributes

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */
data class Person(val id: Int, val name: String, val updateTime: Long) {
    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
                oldItem == newItem
        }
    }
}