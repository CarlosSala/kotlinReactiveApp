package com.example.reactiveapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reactiveapp.databinding.ItemReactiveBinding

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemReactiveBinding.bind(view)

    fun bind(value: String) {
        binding.root.text = value
    }
}