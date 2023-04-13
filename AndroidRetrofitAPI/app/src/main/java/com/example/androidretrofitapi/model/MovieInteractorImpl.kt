package com.example.androidretrofitapi.model

import com.example.androidretrofitapi.presenter.MoviePresenter

class MovieInteractorImpl(val moviePresenter: MoviePresenter) : MovieInteractor {

    private var movieRepository: MovieRepository = MovieRepositoryImpl(moviePresenter)

    override fun getMoviesAPI() {
        movieRepository.getMoviesAPI()
    }
}