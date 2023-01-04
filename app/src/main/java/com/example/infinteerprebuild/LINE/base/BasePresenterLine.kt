package com.example.infinteerprebuild.LINE.base

import com.example.infinteerprebuild.LINE.LineActivity

interface BasePresenterLine<T : BaseViewLine> {
    fun onAttach(view: LineActivity)
    fun onDetach()

}