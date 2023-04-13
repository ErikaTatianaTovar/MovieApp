package com.example.androidretrofitapi.presenter

import com.example.androidretrofitapi.model.vo.Movie

interface MoviePresenter {
    fun setMovies(movies: List<Movie>)
    fun getMovies()
    fun sendError(messageError: String)
}