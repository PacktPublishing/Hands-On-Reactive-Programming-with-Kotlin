package com.example.theseus.movieapp.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey
    val id: Int,
    val title: String,
    val poster_path: String
)