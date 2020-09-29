package com.hi.dhl.startup.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer
import com.hi.dhl.startup.library.LibaryD
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
