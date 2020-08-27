package com.sulistyo.testandroidlumutid.network

import com.sulistyo.testandroidlumutid.model.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("todos")
    fun getData(): Call<List<MainModel>>

    @GET("todos/{id}")
    fun getDetail(@Path("id") id: String?): Call<List<MainModel>>

}