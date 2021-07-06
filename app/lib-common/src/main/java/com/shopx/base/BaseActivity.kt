package com.shopx.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    protected var systemBarHeight = 0
    protected var displayHeight = 0
    protected var displayWidth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        hideStatusBar(window,true)
    }

    fun hideStatusBar(window: Window, darkText: Boolean) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
        var flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && darkText) {
            flag = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        window.decorView.systemUiVisibility = flag or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    protected open fun hideStatusBar(darkText: Boolean) {
        hideStatusBar(window, darkText)
    }

    protected open fun getStatusBarHeight(): Int {
        val id = resources.getIdentifier(
            "status_bar_height", "dimen", "android"
        )
        return if (id > 0) resources.getDimensionPixelSize(id) else id
    }

    protected open fun keepScreenOn(window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    protected fun getDisplaySize() {
        val metric = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metric)
        displayWidth = metric.widthPixels
        displayHeight = metric.heightPixels
    }
}