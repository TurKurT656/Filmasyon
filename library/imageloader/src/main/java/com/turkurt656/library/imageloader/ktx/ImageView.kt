package com.turkurt656.library.imageloader.ktx

import android.graphics.drawable.Drawable
import android.widget.ImageView
import coil.load

private const val BASE_URL = "https://image.tmdb.org/t/p/w500"

fun ImageView.load(
    url: String?,
    fallbackDrawable: Drawable?,
    errorDrawable: Drawable?,
) {

    load(
        url?.let { BASE_URL + it }
    ) {
        crossfade(true)
        fallback(fallbackDrawable)
        error(errorDrawable)
    }
}