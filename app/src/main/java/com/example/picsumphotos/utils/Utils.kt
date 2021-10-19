package com.example.picsumphotos.utils

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}