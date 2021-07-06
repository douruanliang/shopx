package com.shopx.ad

import com.squareup.moshi.Json


data class ApiResponse(
    @Json(name = "ad")
    val ad: Ad,
    @Json(name = "data")
    val myData: List<Data>,
    @Json(name = "page")
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
)

data class Ad(
    @Json(name = "company")
    val company: String,
    @Json(name = "text")
    val text: String,
    @Json(name = "url")
    val url: String
)

data class Data(
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "last_name")
    val lastName: String
)

