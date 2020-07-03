package com.hi.dhl.hilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hi.dhl.hilt.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_hilt.*

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

        btnArgument.setOnClickListener {
            mHitViewModule.passArgument("address : shanghai")
        }
    }
}