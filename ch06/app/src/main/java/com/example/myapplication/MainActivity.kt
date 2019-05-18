package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var textView            : TextView
    lateinit var editText            : EditText
    lateinit var button              : Button

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textViewItem) as TextView
        editText = findViewById(R.id.editText) as EditText
        button = findViewById(R.id.button) as Button
        compositeDisposable = CompositeDisposable()


        // Uncomment one function in one time

        //updateText_EditTextView()
        // mapOperator_ReverseInputWith_EditTextView()
        // debounce_EditTextView()

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }


    fun debounce_EditTextView() {

        textView = findViewById(R.id.textViewItem) as TextView
        editText = findViewById(R.id.editText) as EditText
        val disposable = RxTextView
            .textChanges(editText)
            .debounce(300, TimeUnit.MILLISECONDS)
            .subscribe { textView.text = it }

        compositeDisposable.add(disposable)

    }


    fun mapOperator_ReverseInputWith_EditTextView() {

        textView = findViewById(R.id.textViewItem) as TextView
        editText = findViewById(R.id.editText) as EditText

        val disposable = RxTextView
            .textChanges(editText)
            .map{ it.reversed().toString() }
            .subscribe { textView.text = it }

        compositeDisposable.add(disposable)

    }

    fun updateText_EditTextView() {

        textView = findViewById(R.id.textViewItem) as TextView
        editText = findViewById(R.id.editText) as EditText

        val disposable = RxTextView
            .textChanges(editText)
            .subscribe { textView.text = it }

        compositeDisposable.add(disposable)

    }



    fun filterAndDebounce_EditTextView(){

        textView = findViewById(R.id.textViewItem) as TextView
        editText = findViewById(R.id.editText) as EditText

        val disposable = RxTextView
            .textChanges(editText)
            .filter { it.length > 3 }
            .debounce(500, TimeUnit.MILLISECONDS )
            .subscribe { textView.text = it }

        compositeDisposable.add(disposable)

    }

    fun updateTextWith_Debounce_Map_Scan_ButtonView() {

        textView = findViewById(R.id.textViewItem) as TextView
        button = findViewById(R.id.button) as Button

        val disposable = RxView

            .clicks(button)
            .debounce(1, TimeUnit.SECONDS)
            .map { 1 }
            .scan(0) { acc , next -> acc + next }
            .subscribe {
                textView.text = it.toString()
            }

        compositeDisposable.add(disposable)

    }


    fun updateTextWith_Throttle_Map_Scan_ButtonView() {

        textView = findViewById(R.id.textViewItem) as TextView
        button = findViewById(R.id.button) as Button

        val disposable = RxView

            .clicks(button)
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .map { 1 }
            .scan(0) { acc , next -> acc + next }
            .subscribe {
                textView.text = it.toString()
            }

        compositeDisposable.add(disposable)

    }


    fun updateTextWith_ScanOperator_ButtonView() {

        textView = findViewById(R.id.textViewItem) as TextView
        button = findViewById(R.id.button) as Button

        val disposable = RxView.clicks(button)
            .map { 1 }
            .scan(0) { acc , next -> acc + next }
            .subscribe {
                textView.text = it.toString()
            }

        compositeDisposable.add(disposable)

    }







}
