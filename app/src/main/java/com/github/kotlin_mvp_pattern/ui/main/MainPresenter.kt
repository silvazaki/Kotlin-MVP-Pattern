package com.github.kotlin_mvp_pattern.ui.main

import com.github.kotlin_mvp_pattern.data.Repository
import com.github.kotlin_mvp_pattern.data.model.MovieItemsResponse

/**
 * Created by User on 3/19/2019.
 */

class MainPresenter(private val repository: Repository, private val view: MainInteractor.View?) : MainInteractor.Presenter {
    override fun loadData() {

        repository.getNowPlaying(object : MovieItemsResponse.MovieItemsCallback {
            override fun onSuccess(movieItems: MovieItemsResponse) {

                if (view != null) {
                    view.showLoading(false)
                    view.upDateList(movieItems.movieItems!!)
                }
            }

            override fun onError(message: String) {
                if (view != null) {
                    view.showLoading(false)
                    view.showError("Gagal memuat")
                }

            }

        })
    }
}
