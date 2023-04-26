package com.example.androidretrofitapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidretrofitapi.R
import com.example.androidretrofitapi.model.MoviesObservable
import com.example.androidretrofitapi.model.vo.Movies
import com.example.androidretrofitapi.view.RecyclerMoviesAdapter

class MoviesViewModel : ViewModel() {
    //estados de las vistas y conexiones con observador
    private var moviesObservable: MoviesObservable = MoviesObservable()
    private var recyclerMoviesAdapter: RecyclerMoviesAdapter? = null

    fun callMovies() {
        moviesObservable.callMovies()
    }

    fun getMovies(): MutableLiveData<List<Movies>> {
        return moviesObservable.getMovies()
    }

    fun setMoviesInRecyclerAdapter(movies: List<Movies>) {
        recyclerMoviesAdapter?.setMoviesList(movies)
        recyclerMoviesAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerMoviesAdapter(): RecyclerMoviesAdapter? {
        recyclerMoviesAdapter = RecyclerMoviesAdapter(this, R.layout.item_movie)
        return recyclerMoviesAdapter
    }

    fun getMoviesAt(position: Int): Movies? {
        var movies: List<Movies>? = moviesObservable.getMovies().value
        return movies?.get(position)
    }
}