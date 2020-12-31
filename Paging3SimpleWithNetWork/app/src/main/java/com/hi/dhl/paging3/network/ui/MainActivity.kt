package com.hi.dhl.paging3.network.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.hi.dhl.binding.databind
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import com.hi.dhl.paging3.network.R
import com.hi.dhl.paging3.network.databinding.ActivityMainBinding
import com.hi.dhl.paging3.network.ui.github.FooterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/20
 *     desc  :
 *
 *     DataBindingAppCompatActivity 是基于 DataBinding 封装的 AppCompatActivity
 *     更多信息可以查看 @see <a href="https://github.com/hi-dhl/JDataBinding"></a>
 *
 * </pre>
 */

class MainActivity : DataBindingAppCompatActivity(), AnkoLogger {

    // 通过 koin 依赖注入 MainViewModel
    private val mainViewModel: MainViewModel by viewModel()

    private val githubAdapter by lazy { GitHubAdapter() }

    private val binding: ActivityMainBinding by databind(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bind view
        with(binding) {
            rvList.adapter = githubAdapter.withLoadStateFooter(
                footer = FooterAdapter(githubAdapter)
            )
            swipeRefresh.setOnRefreshListener {
                githubAdapter.refresh()
            }
        }


        mainViewModel.gitHubLiveData.observe(this, Observer { data ->
            githubAdapter.submitData(lifecycle, data)
        })

        /**
         * 处理下拉刷新的状态
         */
        lifecycleScope.launch {
            githubAdapter.loadStateFlow.collectLatest { state ->
                binding.swipeRefresh.isRefreshing = state.refresh is LoadState.Loading
            }
        }

        // 监听数据的状态，显示不同的状态
        githubAdapter.addLoadStateListener { listener ->
            // 监听初始化数据加载时候的状态(成功,失败)
            when (listener.refresh) {
                is LoadState.Error -> { // 加载失败
                    binding.tvResult.setText(listener.refresh.toString())
                    error { listener.refresh.toString() }
                }
                is LoadState.Loading -> { // 正在加载
                    error { listener.refresh.toString() }
                }
                is LoadState.NotLoading -> { // 当前未加载
                    error { listener.refresh.toString() }
                }
            }

            // 监听往头部添加数据的时候的状态(成功,失败)
            when (listener.prepend) {

            }

            // 监听下拉加载更多的时候的数据状态
            when (listener.append) {

            }
        }
    }
}