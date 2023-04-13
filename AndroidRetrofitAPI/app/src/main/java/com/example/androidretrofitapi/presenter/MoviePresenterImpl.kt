package com.example.androidretrofitapi.presenter

import com.example.androidretrofitapi.model.vo.Movie
import com.example.androidretrofitapi.model.MovieRepository
import com.example.androidretrofitapi.model.MovieRepositoryImpl
import com.example.androidretrofitapi.view.MovieView


class MoviePresenterImpl(var movieView: MovieView) : MoviePresenter {

    private var movieRepository: MovieRepository = MovieRepositoryImpl(this)
    override fun getMovies() {
        movieRepository.getMoviesAPI()
    }

    override fun setMovies(movies: List<Movie>) {
        movieView.showMovies(movies)
    }

    override fun sendError(messageError: String) {
        //TODO: Manejar el error visualmente
    }
}

