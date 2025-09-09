package com.example.reactiveapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.reactiveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val itemAdapter = ItemAdapter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = itemAdapter
        ItemsProvider.startEmitting()

        ItemsProvider.observable.observe(this, Observer {
            itemAdapter.items = it
        })
    }
}
