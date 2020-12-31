package com.hi.dhl.paging3.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.hi.dhl.binding.databind
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import com.hi.dhl.paging3.R
import com.hi.dhl.paging3.databinding.ActivityMainBinding
import org.jetbrains.anko.AnkoLogger
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
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

    private val personAdapter by lazy { PersonAdapter() }

    private val binding: ActivityMainBinding by databind(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // bind view
        binding.apply {
            rvList.adapter = personAdapter
            lifecycleOwner = this@MainActivity
        }

        /**
         *  方法三 [MainViewModel.pageDataLiveData3] 推荐
         */
        mainViewModel.pageDataLiveData3.observe(this, Observer { data ->
            personAdapter.submitData(lifecycle, data)
        })

        /**
         * 方法一[MainViewModel.pageDataLiveData] 和方法二 [MainViewModel.pageDataLiveData2] 调用方式相同
         */

//        mMainViewModel.pageDataLiveData2.observe(this, Observer { data ->
//            lifecycleScope.launch {
//                data.collectLatest { mAdapter.submitData(lifecycle, it) }
//            }
//
//        })

        initSwipeToDelete()
    }

    /**
     * 调用 ItemTouchHelper 实现 左右滑动 删除 item 功能
     */
    private fun initSwipeToDelete() {

        /**
         * 位于 [androidx.recyclerview.widget] 包下，已经封装好的控件
         */
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int =
                makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (viewHolder as PersonViewHolder).mBinding.person?.let {
                    // 当 item 左滑 或者 右滑 的时候删除 item
                    mainViewModel.remove(it)
                }
            }
        }).attachToRecyclerView(binding.rvList)
    }
}