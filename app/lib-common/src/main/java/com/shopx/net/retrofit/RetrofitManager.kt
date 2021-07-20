package com.shopx.net.retrofit

import android.util.Log
import com.shopx.net.calladapter.BaseLiveCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * author: dourl
 * created on: 2018/8/6 下午4:06
 * description:
 */
class RetrofitManager private constructor() {
    private val mBuilder: Retrofit.Builder = Retrofit.Builder()
    private var mRetrofit: Retrofit? = null
    private val mOkHttpClient: OkHttpClient? = null

    /**
     * 1 默认
     *
     * @param baseUrl
     * @param client
     */
    fun initRetrofit(baseUrl: String?, client: OkHttpClient?) {
        mBuilder.baseUrl(baseUrl)
        mBuilder.addConverterFactory(GsonConverterFactory.create())
        mBuilder.addCallAdapterFactory(BaseLiveCallAdapterFactory())
        //mBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync());
        initRetrofit(mBuilder, client)
    }

    /**
     * 2初始化方法必须在各种设置完成后最后调用
     *
     * @param builder
     * @param client
     */
    fun initRetrofit(builder: Retrofit.Builder, client: OkHttpClient?) {
        mRetrofit = builder.client(client).build()
    }

    fun <T> create(service: Class<T>): T {
        return if (Debug) {
            val start = System.nanoTime()
            val t = mRetrofit!!.create(service)
            Log.d(
                "ok",
                "create " + service.simpleName + " cost:" + ((System.nanoTime() - start) / 1000000.0).toString()
            )
            t
        } else {
            mRetrofit!!.create(service)
        }
    }

    val okHttpClient: OkHttpClient?
        get() = mOkHttpClient
    val retrofit: Retrofit?
        get() = mRetrofit

    companion object {
        private val mInstance = RetrofitManager()
        fun get(): RetrofitManager {
            return mInstance
        }

        private var Debug = false
        fun enableDebug() {
            Debug = true
        }
    }

}