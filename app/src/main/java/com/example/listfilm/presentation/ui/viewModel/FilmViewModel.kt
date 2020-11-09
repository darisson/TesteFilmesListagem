package com.example.listfilm.presentation.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.listfilm.data.local.database.FilmDataBase
import com.example.listfilm.domain.model.Film
import com.example.listfilm.data.remote.network.RetrofitInitializer
import com.example.listfilm.data.remote.network.service.FilmService
import com.example.listfilm.data.boundary.repository.FilmRepository
import kotlinx.coroutines.launch

class FilmViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository: FilmRepository
    val allFilm: LiveData<List<Film>>
    private val filmService: FilmService

    init {
        val filmDao = FilmDataBase.getDatabase(application, viewModelScope).filmDao()
        filmService = RetrofitInitializer().filmService()
        repository = FilmRepository(filmDao = filmDao)
        allFilm = repository.allFilm
        loadFilm()
    }

    fun loadFilm() = viewModelScope.launch {
        filmService.listFilm().results.forEach {
            val urlBase = "https://image.tmdb.org/t/p/w500/${it.poster_path}"
            Log.d("ASV", "Filme = $it ")
            it.poster_path = urlBase
            insert(it)
        }
    }

    fun insert(film: List<Film>) = viewModelScope.launch {
        repository.insert(film)
    }

    fun insert(film: Film) = viewModelScope.launch {
        repository.insert(film)
    }

    fun update(film: Film) = viewModelScope.launch {
        repository.update(film)
    }

}