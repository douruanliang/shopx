package com.shopx.net.response


/**
 * 对外的数据  eg->LiveCall<BaseDataResponse<T>>
 */
class BaseDataResponse<T>(code: Int, message: String,var data :T) : BaseResponse(code, message) {

}