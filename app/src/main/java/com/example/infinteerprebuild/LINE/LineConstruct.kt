package com.example.infinteerprebuild.LINE

import com.example.infiniteerp.data.remote.response.ListOrderLine
import com.example.infinteerprebuild.LINE.base.BaseViewLine

interface LineConstruct {

    interface view : BaseViewLine {
        fun showDataFood(dataWisata: List<ListOrderLine?>?)
        fun showError(msg: String)
        fun showMessage(msg: String)
        fun onSuccessInsert()
    }

    interface Presenter {
        fun showListLine(id: String)

    }
}