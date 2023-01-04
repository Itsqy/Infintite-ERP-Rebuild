package com.example.infinteerprebuild.HEADER

import android.util.Log
import com.example.infiniteerp.data.remote.response.PurchaseOrderResponse
import com.example.infiniteerpRebuild.base.BasePresenter
import com.example.infinteerprebuild.API.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeaderViewModel(var mainActivity: MainActivity) : BasePresenter<HeaderConstruct.view>,
    HeaderConstruct.Presenter {
    companion object {
        private const val TAG = "LineViewModel"
    }


    override fun showHeader() {

        val service = ApiConfig().getApiService().getAllOrder("demo", "demo")

        service.enqueue(object : Callback<PurchaseOrderResponse> {
            override fun onResponse(
                call: Call<PurchaseOrderResponse>,
                response: Response<PurchaseOrderResponse>
            ) {

                if (response.isSuccessful) {

                    val responseBody = response.body()
                    if (responseBody != null) {
                        val responsBody = response.body()
//                            responsBody?.response?.data
//                            lineActivity?.setListOrderLine(responsBody?.response?.data)
                        mainActivity.showDataHeader(responseBody.response.data)
                    }
                } else {

                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PurchaseOrderResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }


    override fun onAttach(view: MainActivity) {
        mainActivity = view
    }

    override fun onDetach() {
        mainActivity
    }
}