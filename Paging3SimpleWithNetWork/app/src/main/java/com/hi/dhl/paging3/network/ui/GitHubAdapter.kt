package com.hi.dhl.paging3.network.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import com.hi.dhl.jdatabinding.dowithTry
import com.hi.dhl.paging3.network.R
import com.hi.dhl.paging3.network.bean.GitHubAccount

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  : 不久会开发一个基于 databinding 封装的 PagingDataAdapter，只需要几行代码就可以解决
 * </pre>
 */

class GitHubAdapter :
    PagingDataAdapter<GitHubAccount, GitHubViewHolder>(GitHubAccount.diffCallback) {

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        dowithTry {
            val data = getItem(position)
            data?.let {
                holder.bindData(it, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        val view = inflateView(parent, R.layout.recycie_item_github)
        return GitHubViewHolder(view)
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}