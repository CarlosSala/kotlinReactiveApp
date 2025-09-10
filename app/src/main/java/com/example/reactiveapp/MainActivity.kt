package com.example.reactiveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reactiveapp.databinding.ActivityMainBinding

// reactive programming use observe patron
// component observable -> observer, or
// flow data of component observable -> component observer subscribed

class MainActivity : AppCompatActivity() {


    private val adapter = Adapter()
    private lateinit var binding: ActivityMainBinding

    // this lambda function has two responsibilities
    // first - save reference to observer to be able to unsubscribe when activity is onDestroy
    // two - receive data from observable to update UI
    private val observer = { items: List<String> -> adapter.items = items }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        ItemsProvider.startEmitting()

        ItemsProvider.observable.subscribe(observer)
    }

    // when the activity is onDestroy, this is unsubscribed
    override fun onDestroy() {
        ItemsProvider.observable.unsubscribe(observer)
        super.onDestroy()
    }
}
