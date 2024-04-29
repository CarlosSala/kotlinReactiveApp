package com.example.reactiveapp

import android.app.Application


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ItemsProvider.startEmitting()
    }
}