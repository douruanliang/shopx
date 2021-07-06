package com.shopx.net

import com.shopx.ad.ApiResponse
import com.shopx.net.calladapter.BaseLiveCall
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("api/users")
    fun getListData(@Query("page") pageNumber: Int): Call<ApiResponse>
}

