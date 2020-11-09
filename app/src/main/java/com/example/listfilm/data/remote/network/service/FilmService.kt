package com.example.listfilm.data.remote.network.service

import com.example.listfilm.domain.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmService {
    @GET("now_playing?api_key=c2e78b4a8c14e65dd6e27504e6df95ad&language=pt-BR&page=1")
    suspend fun listFilm(): Result

    @GET("https://image.tmdb.org/t/p/w500/{urlImage}")
    suspend fun getImage(@Path("urlImage") urlImage: String): String
}