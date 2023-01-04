package com.example.infinteerprebuild.API

import com.example.infiniteerp.data.remote.response.LineReponse
import com.example.infiniteerp.data.remote.response.LoginResponse
import com.example.infiniteerp.data.remote.response.PurchaseOrderResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("Order")
    fun getAllOrder(
        @Header("Username") username: String = "demo",
        @Header("Password") password: String = "demo",
    ): Call<PurchaseOrderResponse>


    @GET("OrderLine?")
    fun getOrderLine(
        @Header("Username") username: String = "demo",
        @Header("Password") password: String = "demo",
        @Query("_where") id: String,
    ): Call<LineReponse>

}