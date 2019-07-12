package com.example.theseus.movieapp.di.Modules

import android.content.Context
import com.example.theseus.movieapp.R
import com.example.theseus.movieapp.di.qualifiers.ActivityContext
import com.example.theseus.movieapp.ui.main.IMainActivityPresenter
import com.example.theseus.movieapp.ui.main.IMainActivityView
import com.example.theseus.movieapp.ui.main.MainActivityPresenter
import com.example.theseus.movieapp.ui.main.MovieAdapter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.indeterminateProgressDialog

@Module
class MainActivityModule(val context: Context) {

    @Provides
    @ActivityContext
    fun provideContext() = context

    @Provides
    fun provideMainActivityPresenter(mainActivityPresenter: MainActivityPresenter<IMainActivityView>): IMainActivityPresenter<IMainActivityView> = mainActivityPresenter

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideMovieAdapter() = MovieAdapter(context)

    @Provides
    fun provideProgressDialog() = context.indeterminateProgressDialog(context.getString(R.string.please_wait)).apply {
        hide()
    }
}