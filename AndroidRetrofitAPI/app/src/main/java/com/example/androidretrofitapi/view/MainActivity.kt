package com.example.androidretrofitapi.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidretrofitapi.model.vo.Movie
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidretrofitapi.R
import com.example.androidretrofitapi.presenter.MoviePresenter
import com.example.androidretrofitapi.presenter.MoviePresenterImpl

class MainActivity : AppCompatActivity(), MovieView {

    private var moviePresenter: MoviePresenter? = null
    private lateinit var rvMovie: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovie = findViewById(R.id.rv_movies)
        rvMovie.layoutManager = GridLayoutManager(applicationContext, 2)
        getMovies()
    }

    private fun getMovies(){
        moviePresenter = MoviePresenterImpl(this).also {
            it.getMovies()
        }
    }

    override fun showMovies(movies: List<Movie>) {
        val movieAdapter = MovieAdapter(movies, applicationContext)
        rvMovie.adapter = movieAdapter
    }
}