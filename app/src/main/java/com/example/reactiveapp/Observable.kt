package com.example.reactiveapp

class Observable<T>(private var value: T) {

    private val observers: MutableList<(T) -> Unit> = mutableListOf()

    fun subscribe(observer: (T) -> Unit) {

        observer(value)
        observers.add(observer)
    }

    fun unsubscribe(observer: (T) -> Unit) {

        observers.remove(observer)
    }

    fun updateValue(newValue: T) {

        value = newValue
        notifyObservers()
    }

    private fun notifyObservers() {
        observers.forEach {
            it(value)
        }
    }
}