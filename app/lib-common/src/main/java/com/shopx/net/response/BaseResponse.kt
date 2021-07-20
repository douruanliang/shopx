package com.shopx.net.response

import com.shopx.net.model.BaseObject
import com.shopx.net.model.IResponse

open class BaseResponse(val code: Int, val message: String) : BaseObject, IResponse {
    // 根据业务定义code
    override fun isSucceeded(): Boolean {
        return code == 0
    }

    override fun getErrorCode() = code

    override fun getErrorMessage(): String? = message

}
