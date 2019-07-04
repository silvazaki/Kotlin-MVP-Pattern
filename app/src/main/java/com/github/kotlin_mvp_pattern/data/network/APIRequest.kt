package com.github.kotlin_mvp_pattern.data.network

import android.util.Log
import com.github.kotlin_mvp_pattern.data.model.MovieItemsResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by User on 11/26/2018.
 */

class APIRequest {

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private val TAG = "hasil"
    private val client: AsyncHttpClient
    private val gson: Gson
    private val params = RequestParams("api_key", "3dce2cc3191c483d42c878e6409fd560")

    init {
        gson = GsonBuilder().create()
        client = AsyncHttpClient()
    }

    fun getNowPlaying(callback: MovieItemsResponse.MovieItemsCallback) {
        val requestUrl = BASE_URL + "now_playing"
        client.get(requestUrl, params, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {

                var result: String? = null
                val response: JSONObject
                try {
                    response = JSONObject(String(responseBody))
                    result = response.toString()
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e(TAG, "onSuccess: " + e.message)
                }

                Log.e(TAG, "onSuccess: " + result!!)

                val productResponse = gson.fromJson<MovieItemsResponse>(result, MovieItemsResponse::class.java!!)

                if (productResponse != null) {
                    callback.onSuccess(productResponse)
                } else {
                    callback.onError("Cannot get Object" + ErrorCode.NOT_FOUND)
                }
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                callback.onError("Koneksi gagal" + ErrorCode.NO_INTERNET)
            }
        })

    }

    fun cancelAllReq() {
        client.cancelAllRequests(true)
    }

    enum class ErrorCode {
        NOT_FOUND,
        NO_INTERNET,
        SERVER_ERROR
    }


}

