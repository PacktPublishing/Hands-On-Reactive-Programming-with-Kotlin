package com.example.theseus.movieapp.di.Components

import com.example.theseus.movieapp.di.Modules.MainActivityModule
import com.example.theseus.movieapp.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}