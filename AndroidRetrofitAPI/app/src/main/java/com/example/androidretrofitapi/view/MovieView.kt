package com.example.androidretrofitapi.view

import com.example.androidretrofitapi.model.Movie

interface MovieView {
    fun showMovie(movie: List<Movie>)
    fun getMovie()
}
