package com.example.androidretrofitapi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidretrofitapi.BR
import com.example.androidretrofitapi.model.vo.Movies
import com.example.androidretrofitapi.viewmodel.MoviesViewModel

class RecyclerMoviesAdapter(var moviesViewModel: MoviesViewModel, private val resource: Int) :
    RecyclerView.Adapter<RecyclerMoviesAdapter.ItemMovieHolder>() {

    var movies: List<Movies>? = null

    fun setMoviesList(movies: List<Movies>?) {
        if (movies != null) {
            this.movies = movies
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return ItemMovieHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemMovieHolder, position: Int) {
        holder.setDataCard(moviesViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    class ItemMovieHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setDataCard(moviesViewModel: MoviesViewModel, position: Int) {
            binding.setVariable(BR.model, moviesViewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }
}