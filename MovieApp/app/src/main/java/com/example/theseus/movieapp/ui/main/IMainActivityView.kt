package com.example.theseus.movieapp.ui.main

import com.example.theseus.movieapp.ui.base.IBaseView

interface IMainActivityView : IBaseView {
    fun addMoviesToList(results: List<Movie>)
}