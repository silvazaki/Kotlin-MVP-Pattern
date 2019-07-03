package com.github.kotlin_mvp_pattern.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.kotlin_mvp_pattern.R
import com.github.kotlin_mvp_pattern.data.model.MovieItems
import com.github.kotlin_mvp_pattern.utils.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_items.view.*


class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private val data: MutableList<MovieItems> = ArrayList()
    private var callback: Callback.ViewCallback? = null
    private var callbackItem: Callback.ItemCallback? = null

    fun updateData(dataList: List<MovieItems>) {
        data.clear()
        data.addAll(dataList)
        notifyDataSetChanged()
    }

    fun setViewCallback(viewCallback: Callback.ViewCallback) {
        callback = viewCallback
    }

    fun setItemCallback(callbackItemView: Callback.ItemCallback){
        callbackItem = callbackItemView
    }

    fun getItem(position: Int): MovieItems {
        return data[position]
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MovieHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.movie_items, viewGroup, false)
        val holder = MovieHolder(view)
        if (callback != null) {
            view.setOnClickListener { callback!!.onClick(holder.layoutPosition, view) }
        }
        return holder
    }

    override fun onBindViewHolder(movieHolder: MovieHolder, i: Int) {
        val m = data[i]
        movieHolder.tvTitle.text = m.title
        movieHolder.tvDesc.text = m.overview
        Picasso.with(context)
                .load("https://image.tmdb.org/t/p/w185" + m.posterPath!!)
                .into(movieHolder.imgCover)

        callbackItem?.onBindView(movieHolder, i)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.tv_item_name
        var tvDesc: TextView = itemView.tv_item_desc
        var imgCover: ImageView = itemView.img_item_photo
    }

}

