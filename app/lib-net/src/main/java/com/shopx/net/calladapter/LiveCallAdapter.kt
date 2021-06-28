package com.shopx.net.calladapter

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type
import java.util.concurrent.Executor

class LiveCallAdapter<R>(
    private val response: Type,
    private val executor: Executor
) : CallAdapter<R, LiveCall<R>> {
    override fun responseType() = response

    override fun adapt(call: Call<R>): LiveCall<R> = LiveCall(call, executor)


}