package com.example.study.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["image"])
fun ImageView.setImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}
