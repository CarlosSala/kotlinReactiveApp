package com.example.reactiveapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

// reactive programming use observe patron
// in the observe patron we have an observable and an observer or a subscriber of the observable
// the observable gives a flow of data to the observer or subscriber
object ItemsProvider {

    private val _observable = MutableLiveData<List<Item>>()
    val observable: LiveData<List<Item>> get() = _observable
    private var values = emptyList<Item>()

    // Random number generator
    private val random = Random(seed = System.currentTimeMillis())

    fun startEmitting() {
        // GlobalScope is using Default dispatcher and doesn't block the main thread with delay
        // the value is updated in the main thread with withContext(Dispatchers.Main)
        GlobalScope.launch {
            while (true) {
                delay(1000)
                withContext(Dispatchers.Main) {
                    values += Item(randomNum = random.nextInt())
                    _observable.value = values
                }
            }
        }
    }
}