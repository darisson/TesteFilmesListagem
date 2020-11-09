package com.example.listfilm.data.remote.network

import com.example.listfilm.data.remote.network.service.FilmService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit = Retrofit.Builder()
//        .baseUrl("https://jsonplaceholder.typicode.com/")
        .baseUrl("http://api.themoviedb.org/3/movie/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun filmService(): FilmService = retrofit.create(FilmService::class.java)

}