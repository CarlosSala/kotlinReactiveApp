package com.example.reactiveapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reactiveapp.databinding.ItemReactiveBinding

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemReactiveBinding.bind(view)

    fun bind(value: Item) {
        binding.root.text = value.randomNum.toString()
    }
}