package com.shopx.base

import android.app.Application
import java.lang.reflect.InvocationTargetException

/**
 * 反射的Application 需要的地方直接用
 */
class BaseApp private constructor() {
    private object BaseAppHolder {
        private val INSTANCE = BaseApp()
    }

    companion object {
        var application: Application? = null
            private set
    }

    init {
        try {
            val activityThreadClazz = Class.forName("android.app.ActivityThread")
            val currentActivityThreadMethod = activityThreadClazz.getMethod("currentActivityThread")
            currentActivityThreadMethod.isAccessible = true
            val activityThread = currentActivityThreadMethod.invoke(null)
            val getApplicationMethod = activityThread.javaClass.getMethod("getApplication")
            getApplicationMethod.isAccessible = true
            application = getApplicationMethod.invoke(activityThread) as Application
        } catch (e: ClassNotFoundException) {
            throw RuntimeException(e)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException(e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException(e)
        }
    }
}