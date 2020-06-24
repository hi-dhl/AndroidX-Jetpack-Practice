package com.hi.dhl.hilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hi.dhl.hilt.R
import com.hi.dhl.hilt.di.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 *
 * 为项目中的每个 Android 类生成一个 Hilt 组件，这些组件可以从它们各自的父类接收依赖项，
 * 如果是抽象类则不能使用 @AndroidEntryPoint 注解
 *
 * 如果使用 @AndroidEntryPoint 注解 Android 类，还必须注解依赖于它的 Android 类，
 * 例如 如果 注解 fragment 然后还必须注解  fragment 依赖的 Activity, 否则会抛出以下异常
 * java.lang.IllegalStateException: Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: class com.hi.dhl.hilt.ui.MainActivity
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mHitViewModule: HiltViewModel by viewModels()

    @Inject
    lateinit var mHiltSimple: HiltSimple
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jumpFragment.setOnClickListener { startActivity<HitAppCompatActivity>() }
        jumpRoom.setOnClickListener {
            mHitViewModule.insert()
            toast("插入成功")
        }
        jumpSimple.setOnClickListener {
            mHiltSimple.doSomething()
            toast("调用成功，查看控制日志")
        }
    }
}