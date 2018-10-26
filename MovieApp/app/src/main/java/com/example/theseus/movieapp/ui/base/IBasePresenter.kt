package com.example.theseus.movieapp.ui.base

interface IBasePresenter<V : IBaseView> {

    fun onAttach(v: V)

    fun onDetach()
}