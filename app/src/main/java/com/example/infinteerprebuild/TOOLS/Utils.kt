package com.example.infinteerprebuild.TOOLS

object Helpers {
    interface ApiCallbackString {
        fun onResponse(success: Boolean, message: String)
    }
}