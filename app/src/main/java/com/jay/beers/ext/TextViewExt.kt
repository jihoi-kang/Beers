package com.jay.beers.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("listText")
fun TextView.bindListText(list: List<String>) {
    val builder = StringBuilder()
    for (i in list.indices) {
        builder.append(if (i == list.size - 1) list[i] else "${list[i]}, ")
    }
    text = builder.toString()
}