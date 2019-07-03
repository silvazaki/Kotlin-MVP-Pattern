package com.github.kotlin_mvp_pattern.utils


import android.view.View
import com.github.kotlin_mvp_pattern.ui.main.MovieAdapter


interface Callback {
    interface ViewCallback {
        fun onClick(position: Int, view: View)
    }
    interface ItemCallback {
        fun onBindView(holder: MovieAdapter.MovieHolder, position: Int)
    }
}


