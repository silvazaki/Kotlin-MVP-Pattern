package com.github.kotlin_mvp_pattern.data


import android.content.Context
import com.github.kotlin_mvp_pattern.data.local.SharedPrefHelper
import com.github.kotlin_mvp_pattern.data.model.MovieItemsResponse
import com.github.kotlin_mvp_pattern.data.network.APIRequest

class Repository(private val mContext: Context) {
    private val apiRequest: APIRequest
    private val prefs: SharedPrefHelper

    init {
        apiRequest = APIRequest()
        prefs = SharedPrefHelper(mContext)
    }

    fun getNowPlaying(callback: MovieItemsResponse.MovieItemsCallback) {
        apiRequest.getNowPlaying(callback)
    }

}
