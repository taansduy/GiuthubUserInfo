package com.example.githubuserinfo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.githubuserinfo.R

@BindingAdapter("avatar")
fun setAvatar(v: ImageView, url: String?) {
    if (url == null)
        v.setImageResource(R.drawable.ic_user_placeholder)
    else
        v.loadAvatar(url)
}