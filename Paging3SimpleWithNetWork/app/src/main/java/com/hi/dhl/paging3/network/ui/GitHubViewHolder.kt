package com.hi.dhl.paging3.network.ui

import android.view.View
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.hi.dhl.paging3.network.bean.GitHubAccount
import com.hi.dhl.paging3.network.databinding.RecycieItemGithubBinding


/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  : DataBindingViewHolder 是基于 DataBinding 封装的 ViewHolder,
 *     更多信息可以查看 @see <a href="https://github.com/hi-dhl/JDataBinding"></a>
 * </pre>
 */


class GitHubViewHolder(view: View) : DataBindingViewHolder<GitHubAccount>(view) {
    val mBinding: RecycieItemGithubBinding by viewHolderBinding(view)

    override fun bindData(data: GitHubAccount, position: Int) {
        mBinding.apply {
            githubAccount = data
            executePendingBindings()
        }
    }
}