package com.shopx.net.calladapter

import androidx.lifecycle.Lifecycle
import com.shopx.net.BuildConfig
import com.shopx.net.callback.ICallback
import com.shopx.net.exception.BusinessApiException
import com.shopx.net.exception.ExceptionHelper
import com.shopx.net.model.ICall
import com.shopx.net.model.IResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor


/**
 * 自定义返回API 数据最外层数据类型 LiveCall<XXX>
 */
class LiveCall<T>(private val call: Call<T>, private val callbackExecutor: Executor) : ICall<T> {
    override fun cancel() {
        call.cancel()
    }

    override fun enqueue(callback: ICallback<T>, lifecycle: Lifecycle?) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (lifecycle != null) {
                    if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
                        return
                    }
                }
                if (callbackExecutor != null) {
                    callbackExecutor.execute {
                        handleResponse(response, callback);
                    }
                } else {
                    handleResponse(response, callback);
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                if (lifecycle != null) {
                    if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
                        return
                    }
                }

                if (BuildConfig.DEBUG) {
                    t.printStackTrace()
                }

                if (callbackExecutor != null) {
                    callbackExecutor.execute {
                        try {
                            callback?.onFail(ExceptionHelper.transformException(t))
                            callback?.onFinish()
                        } catch (e: Exception) {
                            e.printStackTrace()
                            if (BuildConfig.DEBUG) {
                                throw e
                            }
                        }

                    }
                } else {

                    try {
                        callback?.onFail(ExceptionHelper.transformException(t))
                        callback?.onFinish()
                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                        if (BuildConfig.DEBUG) {
                            throw e
                        }
                    }
                }
            }

        })
    }


    /**
     * 异步处理响应
     */
    private fun handleResponse(response: Response<T>, callback: ICallback<T>) {
        // in 200...299
        try {
            if (response.isSuccessful) {
                val body = response.body()
                body.let {
                    //自定义数据响应
                    if (it is IResponse) {
                        if ((it as IResponse)?.isSucceeded()) {
                            callback?.onSuccess(it)
                        } else {
                            // 请按 api 文档构建 响应类
                            //callback?.onFail(it)
                        }
                    }
                }
            } else {
                //响应失败非 200 业务错误
                val exception = BusinessApiException(
                    response.code(),
                    response.message()
                )
                exception.let {
                    callback?.onFail(exception)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            //TODO debug 模式下 throw
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }

        // 最后
        callback?.onFinish()

    }

    override fun execute(): Response<T>?=call.execute()

    override fun clone(): ICall<T>? {
        return LiveCall(call.clone(),callbackExecutor)
    }


}