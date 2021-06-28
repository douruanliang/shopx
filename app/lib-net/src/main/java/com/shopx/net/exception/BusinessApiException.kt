package com.shopx.net.exception

/**
 * 业务异常
 */
internal class BusinessApiException(val mCode: Int, override val message: String) : ApiException(mCode,message) {

    val INVALIDATE_TOKEN: Int = 401 // 无效TOKEN
    val EXPIRE_TOKEN: Int = 402 // 失效TOKEN
    val SIGN_ERROR: Int = 403  // 登录错误
    val FORCE_UPGRADE: Int = 10011 // 强制更新

    /**
     * 需要退出
     */
    fun isNeedLogout(): Boolean {
        return mCode == INVALIDATE_TOKEN ||  mCode == EXPIRE_TOKEN || mCode == FORCE_UPGRADE || mCode == SIGN_ERROR
    }

    /**
     * 需要强升级
     */
    fun isForceUpgrade():Boolean{
        return mCode == FORCE_UPGRADE
    }
}