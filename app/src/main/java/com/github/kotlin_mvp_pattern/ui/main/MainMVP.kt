package com.github.kotlin_mvp_pattern.ui.main

import com.github.kotlin_mvp_pattern.data.model.MovieItems

/**
 * Created by User on 3/19/2019.
 */

class MainMVP {
    interface View {
        fun showLoading(isLoading: Boolean)

        fun showError(message: String)

        fun upDateList(movieItems: List<MovieItems>)

    }


    interface Presenter {
        fun loadData()
    }
}
