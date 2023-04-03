package com.example.androidretrofitapi.presenter

import com.example.androidretrofitapi.model.Movie

interface MoviePresenter {
    fun showMovie(movie: List<Movie>)
    fun getMovie()
}