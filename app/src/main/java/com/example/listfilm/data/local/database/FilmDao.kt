package com.example.listfilm.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.listfilm.domain.model.Film

@Dao
interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(film: Film)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(film: List<Film>)

    @Query("DELETE FROM film_table")
    suspend fun deleteAllEvents()

    @Query("SELECT * FROM film_table")
    fun getAllFilm(): LiveData<List<Film>>

    @Update(entity = Film::class)
    suspend fun update(film: Film)
}