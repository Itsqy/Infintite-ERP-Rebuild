package com.example.infiniteerpRebuild.base

import com.example.infinteerprebuild.HEADER.MainActivity


interface BasePresenter<T : BaseView> {
    fun onAttach(view: MainActivity)
    fun onDetach()

}