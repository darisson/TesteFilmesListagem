package com.example.listfilm.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.listfilm.R

fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.no_image_available)
        .into(this)
}