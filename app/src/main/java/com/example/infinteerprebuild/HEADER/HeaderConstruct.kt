package com.example.infinteerprebuild.HEADER

import com.example.infinteerprebuild.RESPONSE.ListOrder
import com.example.infiniteerpRebuild.base.BaseView

interface HeaderConstruct {

    interface view : BaseView {
        fun showDataHeader(dataHeader: List<ListOrder?>?)
        fun showError(msg: String)
        fun showMessage(msg: String)
        fun onSuccessInsert()
    }

    interface Presenter {
        fun showHeader(docStatus: String)

    }
}