package com.example.listfilm.data.boundary.repository

import androidx.lifecycle.LiveData
import com.example.listfilm.data.local.database.FilmDao
import com.example.listfilm.domain.model.Film

class FilmRepository (
    private val filmDao: FilmDao
) {
    val allFilm: LiveData<List<Film>> = filmDao.getAllFilm()

    suspend fun insert(film: List<Film>) {
        filmDao.insert(film)
    }

    suspend fun insert(film: Film) {
        filmDao.insert(film)
    }

    suspend fun update(film: Film) {
        filmDao.insert(film)
    }
}