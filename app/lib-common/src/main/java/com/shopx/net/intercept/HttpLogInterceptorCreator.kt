package com.shopx.net.intercept

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class HttpLogInterceptorCreator {

    companion object {
        fun create(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor { message -> Log.v("OkHttp", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }
    }
}