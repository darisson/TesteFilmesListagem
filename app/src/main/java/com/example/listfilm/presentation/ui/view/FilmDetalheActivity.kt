package com.example.listfilm.presentation.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listfilm.R
import com.example.listfilm.extension.loadImage
import com.example.listfilm.domain.model.Film
import com.example.listfilm.extension.dateToString
import kotlinx.android.synthetic.main.activity_film_detalhe.*

class FilmDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detalhe)

        val film = intent.getSerializableExtra("film") as Film

        imagFilm.loadImage(film.poster_path)
        titleFilm.text = film.title
        textVoteAverage.text = film.vote_average.toString()
        textDate.text = film.release_date.dateToString()
        overviewDetail.text = film.overview
    }
}