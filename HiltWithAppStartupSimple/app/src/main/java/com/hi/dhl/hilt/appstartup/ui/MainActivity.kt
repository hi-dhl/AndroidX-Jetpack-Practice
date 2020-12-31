package com.hi.dhl.hilt.appstartup.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hi.dhl.binding.viewbind
import com.hi.dhl.hilt.appstartup.data.WorkService
import com.hi.dhl.hilt.appstartup.databinding.ActivityMainBinding
import com.hi.dhl.hilt.appstartup.di.HiltSimple
import dagger.hilt.android.AndroidEntryPoint
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
 * java.lang.IllegalStateException: Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: class com.hi.dhl.hilt.appstartup.ui.MainActivity
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * 在 App 模块中的 build.gradle 文件中添加以下代码，否则调用 `by viewModels()` 会编译不过
     *
     *    kotlinOptions {
     *      jvmTarget = "1.8"
     *    }
     *
     */
    private val mHitViewModule: HiltViewModel by viewModels()
    private val binding: ActivityMainBinding by viewbind()

    @Inject
    lateinit var mAnalyticsService: WorkService

    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews().forEach {
            it.setOnClickListener(this)
        }

        Log.e(TAG, mHiltSimple.toString())
    }

    private fun getViews() = binding.run {
        arrayListOf(jumpFragment, jumpRoom, jumpSimple, jumpBind)
    }

    override fun onClick(v: View) {
        with(binding) {
            when (v) {
                jumpFragment -> startActivity<HitAppCompatActivity>()
                jumpRoom -> {
                    mHitViewModule.insert()
                    toast("插入成功")
                }
                jumpSimple -> {
                    mHiltSimple.doSomething()
                    toast("调用成功，查看控制台日志")
                }
                jumpBind -> {
                    mAnalyticsService.init()
                    toast("调用成功，查看控制台日志")
                }
                else -> {

                }
            }
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}