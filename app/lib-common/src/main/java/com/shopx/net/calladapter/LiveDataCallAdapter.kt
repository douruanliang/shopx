package com.shopx.net.calladapter

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 */
class LiveDataCallAdapter<R>(private val responseType: Type){

}