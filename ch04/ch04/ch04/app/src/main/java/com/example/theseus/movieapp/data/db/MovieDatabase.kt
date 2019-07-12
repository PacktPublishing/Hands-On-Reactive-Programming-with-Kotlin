package com.example.theseus.movieapp.data.db;

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.theseus.movieapp.data.db.model.Movie
import com.example.theseus.movieapp.data.db.model.MovieDao

@Database(entities = [Movie::class]
        , version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDAO(): MovieDao

    companion object {

        const val DB_NAME = "movie.db"

        @Volatile private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context,
                        MovieDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }
}