package com.example.androidretrofitapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidretrofitapi.R
import com.example.androidretrofitapi.databinding.ActivityMainBinding
import com.example.androidretrofitapi.model.vo.Movies
import com.example.androidretrofitapi.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {


    private var moviesViewModel: MoviesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings(savedInstanceState)
    }
    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        activityMainBinding.setModel(moviesViewModel)
        setupListUpdate()
    }

    //levantar el recyclerview
    fun setupListUpdate() {
        moviesViewModel?.callMovies()
        moviesViewModel?.getMovies()?.observe(this, Observer {
                movies: List<Movies> ->
            Log.w("MOVIES", movies.get(0).title ?: "No encontro titulo")
            moviesViewModel?.setMoviesInRecyclerAdapter(movies)
        })
    }
}