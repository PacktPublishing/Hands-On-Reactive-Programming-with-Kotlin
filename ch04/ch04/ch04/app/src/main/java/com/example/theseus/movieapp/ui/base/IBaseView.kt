package com.example.theseus.movieapp.ui.base

interface IBaseView {
    fun showProgressBar()
    fun hideProgressDialog()
    fun showError(errorStr: String)
}