package com.shopx.utils

import android.content.Context
import android.text.TextUtils
import com.tencent.mmkv.MMKV
import java.io.Serializable

class MMKVUtils private constructor() : Serializable {

    @Volatile
    private var mmkvDir: String? = null
    private var mmkv: MMKV? = null

    companion object {
        @JvmStatic
        val instance: MMKVUtils by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            MMKVUtils()
        }
    }

    private fun readResolve(): Any {
        return instance
    }

    /**
     * 必须要 初始化的
     */
    public fun initMMKV(context: Context) {
        synchronized(this) {
            if (TextUtils.isEmpty(mmkvDir)) {
                mmkvDir = MMKV.initialize(context)
                mmkv = MMKV.defaultMMKV(MMKV.SINGLE_PROCESS_MODE, null)!!
            }
        }
    }

    /**
     * 读取 String
     */
    public fun decodeString(key: String?, value: String?): String? {
        return mmkv?.decodeString(key, value)
    }

    /**
     * 写入 String
     */
    fun encodeString(key: String?, value: String?) {
        mmkv?.encode(key, value)
    }
}