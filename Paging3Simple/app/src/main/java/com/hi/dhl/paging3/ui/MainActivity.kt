package com.hi.dhl.paging3.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import com.hi.dhl.paging3.R
import com.hi.dhl.paging3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jetbrains.anko.AnkoLogger
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * DataBindingAppCompatActivity 是基于 DataBinding 封装的 AppCompatActivity
 */
class MainActivity : DataBindingAppCompatActivity(), AnkoLogger {

    private val mMainViewModel: MainViewModel by viewModel()
    private val mAdapter by lazy { PersonAdapter() }

    private val mBinding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.apply {
            lifecycleOwner = this@MainActivity
            rvList.adapter = mAdapter
        }

        /**
         *  方法三 [MainViewModel.pageDataLiveData3] 推荐
         */
        mMainViewModel.pageDataLiveData3.observe(this, Observer { data ->
            mAdapter.submitData(lifecycle, data)
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

        // 方法四
//        lifecycleScope.launch {
//            mMainViewModel.postOfPerson().collectLatest { mAdapter.submitData(it) }
//        }

        initSwipeToDelete()
    }

    /**
     * 当左右滑动 item 时，删除对应的条目
     */
    private fun initSwipeToDelete() {
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
                    mMainViewModel.remove(it)
                }
            }
        }).attachToRecyclerView(rvList)
    }
}