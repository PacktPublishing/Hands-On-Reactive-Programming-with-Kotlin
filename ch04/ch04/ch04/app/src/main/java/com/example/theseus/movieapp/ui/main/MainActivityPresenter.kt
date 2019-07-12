package com.example.theseus.movieapp.ui.main

import com.example.theseus.movieapp.data.IDataManager
import com.example.theseus.movieapp.data.api.model.TopRatedMovieResponse.ResultsItem
import com.example.theseus.movieapp.data.db.model.Movie
import com.example.theseus.movieapp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityPresenter<V : IMainActivityView> @Inject constructor(private val mDataManager: IDataManager, private val mCompositeDisposable: CompositeDisposable) : BasePresenter<V>(),
    IMainActivityPresenter<V> {

    override fun onAttach(v: V) {
        super.onAttach(v)
        view?.showProgressBar()
        mCompositeDisposable.add(
            mDataManager
                .fetchMoviesFromAPI()
                .subscribeOn(Schedulers.io())
                .map {
                    it.results.map {
                        it.toMovie()
                    }
                }
                .doOnSuccess {
                    mDataManager.clearMoviesFromDatabase()
                    mDataManager.saveMoviesInDatabase(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        view?.hideProgressDialog()
                        view?.addMoviesToList(it)
                    }, onError = {
                        view?.hideProgressDialog()
                        view?.showError(it.localizedMessage)
                    }
                )
        )
    }

    override fun onDetach() {
        super.onDetach()
        mCompositeDisposable.dispose()
    }
}

private fun ResultsItem.toMovie() = Movie(id, title, posterPath)
