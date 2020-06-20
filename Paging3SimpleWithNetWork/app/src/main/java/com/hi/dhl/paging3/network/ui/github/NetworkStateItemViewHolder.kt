package com.hi.dhl.paging3.network.ui.github

import android.view.View
import androidx.paging.LoadState
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.hi.dhl.paging3.network.databinding.RecycieItemNetworkStateBinding

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 * </pre>
 */
class NetworkStateItemViewHolder(view: View, private val retryCallback: () -> Unit) :
    DataBindingViewHolder<LoadState>(view) {
    val mBinding: RecycieItemNetworkStateBinding by viewHolderBinding(view)

    override fun bindData(data: LoadState, position: Int) {
        mBinding.apply {

            progressBar.isVisible = data is LoadState.Loading
            retryButton.isVisible = data is LoadState.Error
            retryButton.setOnClickListener { retryCallback() }
            errorMsg.isVisible = !(data as? LoadState.Error)?.error?.message.isNullOrBlank()
            errorMsg.text = (data as? LoadState.Error)?.error?.message

            executePendingBindings()
        }
    }
}

inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }