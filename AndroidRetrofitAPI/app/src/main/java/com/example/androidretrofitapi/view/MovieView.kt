package com.example.androidretrofitapi.view

import com.example.androidretrofitapi.model.vo.Movie

interface MovieView {
    fun showMovies(movies: List<Movie>)
}
