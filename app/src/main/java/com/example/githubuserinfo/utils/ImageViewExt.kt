package com.example.githubuserinfo.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.githubuserinfo.R

fun ImageView.loadAvatar(url: String?) {
    Glide.with(this)
        .load(url)
        .optionalFitCenter()
        .circleCrop()
        .placeholder(R.drawable.ic_user_placeholder)
        .error(R.drawable.ic_user_placeholder)
        .into(this)
}