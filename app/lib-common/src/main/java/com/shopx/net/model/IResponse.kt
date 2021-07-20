package com.shopx.net.model

internal interface IResponse {
    /**
     * 业务逻辑上是否成功
     * @return true代表成功
     */
    fun isSucceeded(): Boolean

    /**
     * 获取业务逻辑出错代码
     * @return
     */
    fun getErrorCode(): Int

    /**
     * 获取出错信息
     * @return
     */
    fun getErrorMessage(): String?
}