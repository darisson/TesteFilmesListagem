package com.example.listfilm.presentation.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listfilm.R
import com.example.listfilm.presentation.ui.adapter.FilmAdapter
import com.example.listfilm.domain.model.Film
import com.example.listfilm.presentation.ui.viewModel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listaPost: MutableList<Film> = mutableListOf()
    private lateinit var filmViewModel: FilmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Courtines
        val postAdapter = FilmAdapter(applicationContext)

        filmViewModel = ViewModelProvider(this).get(FilmViewModel::class.java)
        filmViewModel.loadFilm()
        filmViewModel.allFilm.observe(this, Observer { events ->
            if (events.isNullOrEmpty()) {
                Log.d("ASV", "Lista vazia")
            } else {
                events?.let {
                    listaPost.clear()
                    listaPost.addAll(it)
                    postAdapter.setEvents(it)
                    recyclerView.adapter = postAdapter
//                    recyclerView.layoutManager =
//                        LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                }
            }

        })


    }

}