package com.shopx.net.exception


/**
 * API异常
 */
open class ApiException(code: Int, message: String) : Exception(message) {
}