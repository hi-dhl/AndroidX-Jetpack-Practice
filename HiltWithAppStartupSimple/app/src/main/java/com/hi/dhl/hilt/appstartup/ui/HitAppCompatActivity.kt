package com.hi.dhl.hilt.appstartup.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hi.dhl.hilt.appstartup.R
import com.hi.dhl.hilt.appstartup.di.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hilt.*
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

    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)
        // 用到了 Fragment 1.2.0 中重要的更新
        // 可以查看之前写的这篇文章 @see https://juejin.im/post/5ecb16f1f265da76fb0c3967
        supportFragmentManager.beginTransaction()
            .add(R.id.container, HiltFragment::class.java, null)
            .commit()

        mHitViewModule.mHitLiveData.observe(this, Observer {
            tvResult.setText(it)
        })

        Log.e(TAG, mHiltSimple.toString())
    }


    companion object {
        private val TAG = "HitAppCompatActivity"
    }
}