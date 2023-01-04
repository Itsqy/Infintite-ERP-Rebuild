package com.example.infinteerprebuild.API

import com.example.infinteerprebuild.RESPONSE.LineReponse
import com.example.infinteerprebuild.RESPONSE.PurchaseOrderResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {
    @GET("Order")
    fun getAllOrder(
        @Header("Username") username: String = "demo",
        @Header("Password") password: String = "demo",
        @Query("_where") id: String,
    ): Call<PurchaseOrderResponse>


    @GET("OrderLine?")
    fun getOrderLine(
        @Header("Username") username: String = "demo",
        @Header("Password") password: String = "demo",
        @Query("_where") id: String,
    ): Call<LineReponse>

}