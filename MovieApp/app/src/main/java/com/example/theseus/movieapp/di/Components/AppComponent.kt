package com.example.theseus.movieapp.di.Components

import com.example.theseus.movieapp.di.Modules.AppModule
import com.example.theseus.movieapp.di.Modules.MainActivityModule
import com.example.theseus.movieapp.di.Modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class, NetworkModule::class] )
interface AppComponent {

    fun mainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent
}