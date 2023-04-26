package com.example.androidretrofitapi.model

import androidx.lifecycle.MutableLiveData
import com.example.androidretrofitapi.model.vo.Movies

interface MovieRepository {
    fun getMovies(): MutableLiveData<List<Movies>>
    fun callMoviesAPI()
}