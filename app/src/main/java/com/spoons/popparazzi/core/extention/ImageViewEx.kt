package com.spoons.popparazzi.core.extention

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.glide(url: String) = Glide.with(this)
    .load(url)
    .into(this)

fun ImageView.glide(@DrawableRes res: Int) = Glide.with(this)
    .load(res)
    .into(this)