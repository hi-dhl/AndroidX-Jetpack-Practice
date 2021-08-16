package com.hi.dhl.splashscreen.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hi.dhl.binding.viewbind
import com.hi.dhl.splashscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewbind()
    private var appReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        with(binding) {
            // init view
        }

        /**
         * 保持持启动画面可见，直到我们的应用准备好。因为可能从本地磁盘或者网络异步加载数据，
         * 通过这个方法可以让应用暂停绘制第一帧。
         */
        splashScreen.setKeepVisibleCondition { !appReady }

        // 实现退出动画
        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            val splashScreenView = splashScreenViewProvider.view
            val iconView = splashScreenViewProvider.iconView
            val translationY = ObjectAnimator.ofFloat(
                iconView,
                View.TRANSLATION_Y,
                iconView.translationY,
                splashScreenView.height.toFloat()
            )
            translationY.interpolator = AnticipateInterpolator()
            translationY.duration = 2000L
            translationY.doOnEnd { splashScreenViewProvider.remove() }
            translationY.start()
        }

        // 模拟从本地磁盘或者网络异步加载数据的耗时操作
        Handler(Looper.getMainLooper())
            .postDelayed({ appReady = true }, 3000)
    }
}
