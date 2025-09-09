package com.example.reactiveapp

import android.app.Application

// When a class heritage from Application(), this class is executed when the app is started
// before any activity, service or broadcast receiver is created.
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // this function is used to start the observable and emit the values
        ItemsProvider.startEmitting()
    }
}