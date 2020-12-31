package com.hi.dhl.hilt.appstartup.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hi.dhl.binding.viewbind
import com.hi.dhl.hilt.appstartup.R
import com.hi.dhl.hilt.appstartup.databinding.ActivityHiltBinding
import com.hi.dhl.hilt.appstartup.di.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/24
 *     desc  :
 * </pre>
 */
@AndroidEntryPoint
class HitAppCompatActivity : AppCompatActivity() {
    private val mHitViewModule: HiltViewModel by viewModels()
    private val binding: ActivityHiltBinding by viewbind()

    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 用到了 Fragment 1.2.0 中重要的更新
        // 可以查看之前写的这篇文章 @see https://juejin.im/post/5ecb16f1f265da76fb0c3967
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, HiltFragment::class.java, null)
            .commit()

        mHitViewModule.mHitLiveData.observe(this, Observer {
            binding.tvResult.setText(it)
        })

        binding.btnArgument.setOnClickListener {
            mHitViewModule.passArgument("address : shanghai")
        }
    }


    companion object {
        private val TAG = "HitAppCompatActivity"
    }
}