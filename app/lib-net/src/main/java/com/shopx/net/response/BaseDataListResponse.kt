package com.shopx.net.response

import android.text.TextUtils
import com.shopx.net.model.IDataList

/**
 *  返回是 list
 */
class BaseDataListResponse<T>(code: Int, message: String, val next: Int, val data: List<T>) :
    BaseResponse(code, message), IDataList<T> {

    override fun getList(): List<T> = data

}