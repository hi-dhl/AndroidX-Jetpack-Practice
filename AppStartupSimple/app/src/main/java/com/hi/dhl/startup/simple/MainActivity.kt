package com.hi.dhl.startup.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer
import com.hi.dhl.binding.viewbind
import com.hi.dhl.startup.library.LibaryD
import com.hi.dhl.startup.simple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            handView.setOnClickListener {
                AppInitializer.getInstance(applicationContext)
                    .initializeComponent(LibaryD::class.java)

                if (LibaryD.Dependency.initializer) {
                    tvTip.setText("手动初始化成功")
                } else {
                    tvTip.setText("手动初始化失败")
                }
            }
        }
    }
}
