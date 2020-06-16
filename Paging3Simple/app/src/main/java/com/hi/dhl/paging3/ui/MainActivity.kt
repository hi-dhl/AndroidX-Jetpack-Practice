package com.hi.dhl.paging3.ui

import android.os.Bundle
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import com.hi.dhl.paging3.R
import com.hi.dhl.paging3.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * DataBindingAppCompatActivity 是基于 DataBinding 封装的 AppCompatActivity
 */
class MainActivity : DataBindingAppCompatActivity() {

    private val mMainViewModel: MainViewModel by viewModel()

    private val mBinding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.apply {

        }
    }
}