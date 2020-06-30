package com.hi.dhl.hilt.hilt.module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mHitViewModule: HiltViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jumpRoom.setOnClickListener {
            mHitViewModule.insert()
            toast("插入成功")
        }
    }
}