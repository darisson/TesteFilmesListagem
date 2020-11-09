package com.example.listfilm.presentation.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listfilm.presentation.ui.view.FilmDetalheActivity
import com.example.listfilm.R
import com.example.listfilm.extension.loadImage
import com.example.listfilm.domain.model.Film
import com.example.listfilm.extension.dateToString
import kotlinx.android.synthetic.main.recycler_film_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class FilmAdapter(
    private val contexto: Context
): RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    private var lista: List<Film> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder{
        val view = LayoutInflater.from(contexto).inflate(R.layout.recycler_film_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.title.text = lista[position].title
        holder.voteAverage.text = lista[position].vote_average.toString()
        holder.image.loadImage(lista[position].poster_path)
        holder.date.text = lista[position].release_date.dateToString()
        holder.card.setOnClickListener {
            contexto.startActivity(
                Intent(
                    contexto,
                    FilmDetalheActivity::class.java
                ).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    putExtra("film", lista[position])
            })
        }
    }

    override fun getItemCount(): Int {
        return lista.count()
    }

    inner class FilmViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var card: CardView = view.cardFilm
        var title: TextView = view.titleFilm
        var voteAverage: TextView = view.voteAverageFilm
        var image: ImageView = view.imagFilm
        var date: TextView = view.dateFilm
    }

    fun setEvents(film: List<Film>) {
        this.lista = film
        notifyDataSetChanged()
    }

//    fun dataToText(data: String): String {
////        val date = Calendar.getInstance()
//        val dataArray = data.split("-")
//        return "${dataArray[2]}/${dataArray[1]}/${dataArray[0]}"
//////        val formatador = SimpleDateFormat("dd/MM/yyyy")
//////        val dataFormatada = formatador.format(date.time)
////        return dataFormatada
//    }
}