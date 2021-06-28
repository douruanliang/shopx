package com.shopx.net.callback

import com.shopx.net.exception.ApiException

/**
 * 页面使用的回调
 */
interface ICallback<T> {
    fun onSuccess(baseData: T)

    /**
     *
     */
    fun onFail(error: ApiException)
    fun onFinish()
}