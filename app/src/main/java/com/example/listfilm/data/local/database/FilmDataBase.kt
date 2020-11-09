package com.example.listfilm.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.listfilm.domain.model.Film
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Film::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FilmDataBase: RoomDatabase() {

    abstract fun filmDao(): FilmDao

    companion object {
        @Volatile
        private var INSTANCE: FilmDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): FilmDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilmDataBase::class.java,
                    "film_database"
                )
                    .addCallback(FilmDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class FilmDatabaseCallback(
            private val scope: CoroutineScope
        ): RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.filmDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(filmDao: FilmDao) {
            filmDao.deleteAllEvents()
        }
    }
}