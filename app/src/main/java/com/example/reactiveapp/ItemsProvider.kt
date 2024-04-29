package com.example.reactiveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random


object ItemsProvider {

    private val _observable = MutableLiveData<List<String>>()
    val observable: LiveData<List<String>> get() = _observable

    // val observable = Observable<List<String>>(emptyList())
    private var values = emptyList<String>()
    private val random = Random(System.currentTimeMillis())

    fun startEmitting() {

        GlobalScope.launch(Dispatchers.IO) {

            while (true) {

                delay(1000)

                withContext(Dispatchers.Main) {

                    values += random.nextInt().toString()
                    _observable.value = values
                    // observable.updateValue(values)
                }
            }
        }
    }
}