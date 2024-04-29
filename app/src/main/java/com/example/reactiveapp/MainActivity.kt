package com.example.reactiveapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.reactiveapp.databinding.ActivityMainBinding

// reactive programming use observe patron
// component observable -> observer, or
// flow data of component observable -> component observer subscribed

class MainActivity : AppCompatActivity() {


    private val adapter = Adapter()
    private lateinit var binding: ActivityMainBinding
    // private val observer = { items: List<String> -> adapter.items = items }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        ItemsProvider.startEmitting()

        ItemsProvider.observable.observe(this, Observer {
            adapter.items = it
        })

        // ItemsProvider.observable.subscribe(observer)
    }

    // when the activity is onDestroy, this is unsubscribed
/*    override fun onDestroy() {
        ItemsProvider.observable.unsubscribe(observer)
        super.onDestroy()
    }*/
}
