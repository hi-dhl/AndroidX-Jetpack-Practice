package com.hi.dhl.hilt.hilt.module

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.hilt.hilt.module.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.toast

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mHitViewModule: HiltViewModel by viewModels()
    private val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.jumpRoom.setOnClickListener {
            mHitViewModule.insert()
            toast("插入成功")
        }
    }
}