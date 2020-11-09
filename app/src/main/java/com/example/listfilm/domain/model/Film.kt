package com.example.listfilm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "film_table")
data class Film(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val vote_average: Double,
    val original_title: String,
    val original_language: String,
    val adult: Boolean,
    val video: Boolean,
    val vote_count: Int,
    val popularity: Double,
    var poster_path: String,
    val backdrop_path: String
): Serializable