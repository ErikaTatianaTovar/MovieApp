package com.example.androidretrofitapi.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl("https://demo0526662.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit!!
    }
}
