package com.example.infinteerprebuild.LINE

import android.util.Log
import com.example.infinteerprebuild.RESPONSE.LineReponse
import com.example.infinteerprebuild.RESPONSE.ListOrderLine
import com.example.infinteerprebuild.API.ApiConfig
import com.example.infinteerprebuild.LINE.base.BasePresenterLine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LineViewModel(var lineActivity: LineActivity) : BasePresenterLine<LineConstruct.view>,
    LineConstruct.Presenter {
    companion object {
        private const val TAG = "LineViewModel"
    }


    override fun showListLine(id: String) {

        val client = ApiConfig().getApiService()
            .getOrderLine("demo", "demo", "salesOrder='$id'")


        client.enqueue(object : Callback<LineReponse> {
            override fun onResponse(
                call: Call<LineReponse>,
                response: Response<LineReponse>
            ) {

                if (response.isSuccessful) {

                    val responseBody = response.body()
                    if (responseBody != null) {
                        lineActivity.showDataLine(responseBody.response.data as List<ListOrderLine>)
                    }
                } else {

                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LineReponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }


    override fun onAttach(view: LineActivity) {
        lineActivity = view
    }

    override fun onDetach() {
        lineActivity
    }
}