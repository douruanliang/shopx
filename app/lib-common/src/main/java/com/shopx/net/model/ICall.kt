package com.shopx.net.model

import androidx.lifecycle.Lifecycle
import com.shopx.net.callback.ICallback
import retrofit2.Response
import java.io.IOException

interface ICall<T> {
    fun cancel()
    fun enqueue(callback: ICallback<T>, lifecycle: Lifecycle?)

    @Throws(IOException::class)
    fun execute(): Response<T>?
    fun clone(): ICall<T>?
}