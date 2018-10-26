package com.example.theseus.movieapp.ui.main

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.theseus.movieapp.MovieApplication
import com.example.theseus.movieapp.R
import com.example.theseus.movieapp.di.Modules.MainActivityModule
import com.example.theseus.movieapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {
    @Inject
    lateinit var mMainActivityPresenter: IMainActivityPresenter<IMainActivityView>

    @Inject
    override
    lateinit var mProgressDialog: ProgressDialog

    @Inject
    lateinit var mAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MovieApplication).movieComponent
            .mainActivityComponent(MainActivityModule(this)).inject(this)

        // setup Recyclerview
        movie_list.setHasFixedSize(true)
        movie_list.layoutManager = GridLayoutManager(this, 2)
        movie_list.adapter = mAdapter
        mMainActivityPresenter.onAttach(this)
    }

    override fun addMoviesToList(results: List<Movie>) {
        mAdapter.movieList = results
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainActivityPresenter.onDetach()
        mProgressDialog.dismiss()
    }
}

