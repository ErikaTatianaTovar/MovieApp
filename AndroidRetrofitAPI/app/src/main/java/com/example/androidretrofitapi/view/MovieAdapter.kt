package com.example.androidretrofitapi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidretrofitapi.R
import com.example.androidretrofitapi.model.vo.Movie

class MovieAdapter(private val movies: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_title.text = movies[position].title
        Glide.with(context).load(movies[position].coverPage).into(holder.iv_coverPage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_coverPage: ImageView = itemView.findViewById(R.id.iv_coverPage)
        val tv_title: TextView = itemView.findViewById(R.id.iv_title)
    }
}