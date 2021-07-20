package com.shopx.net.model

interface IDataList<T> : BaseObject {
    fun getList(): List<T>
}