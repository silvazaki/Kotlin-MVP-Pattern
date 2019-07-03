package com.github.kotlin_mvp_pattern.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by User on 3/19/2019.
 */

class MovieItemsResponse {
    @SerializedName("results")
    var movieItems: List<MovieItems>? = null

    interface MovieItemsCallback {
        fun onSuccess(movieItems: MovieItemsResponse)
        fun onError(message: String)
    }
}
