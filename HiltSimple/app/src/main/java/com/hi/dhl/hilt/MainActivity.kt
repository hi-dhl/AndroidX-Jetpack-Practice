package com.hi.dhl.hilt

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *
 * 为项目中的每个 Android 类生成一个 Hilt 组件，这些组件可以从它们各自的父类接收依赖项，
 * 如果是抽象类则不能使用 @AndroidEntryPoint 注解
 *
 * 如果使用 @AndroidEntryPoint 注解 Android 类，还必须注解依赖于它的 Android 类，
 * 例如 如果 注解 fragment 然后还必须注解  fragment 依赖的 Activity, 否则会抛出以下异常
 * java.lang.IllegalStateException: Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: class com.hi.dhl.hilt.MainActivity
 */
//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // 使用 @Inject 注解从组件中获取依赖


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, HiltFragment::class.java, null)
            .commit()
    }
}