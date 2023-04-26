package com.example.androidretrofitapi.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.androidretrofitapi.model.vo.Movies

class MoviesObservable: BaseObservable() {

    private var moviesRepository: MovieRepository = MovieRepositoryImpl()
    //repositorio

    fun callMovies(){
moviesRepository.callMoviesAPI()
    }
    //view model
    fun getMovies(): MutableLiveData<List<Movies>> {
        return moviesRepository.getMovies()
    }
}