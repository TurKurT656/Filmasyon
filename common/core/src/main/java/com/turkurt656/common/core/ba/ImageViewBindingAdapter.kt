package com.turkurt656.common.core.ba

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.turkurt656.library.imageloader.ktx.load

object ImageViewBindingAdapter {

    @BindingAdapter(
        "binding:imageUrl",
        "binding:fallbackDrawable",
        "binding:errorDrawable",
        requireAll = false
    )
    @JvmStatic
    fun loadUrl(
        imageView: ImageView,
        url: String?,
        fallbackDrawable: Drawable?, // Default is null
        errorDrawable: Drawable?, // Default is fallbackDrawable
    ) {
        imageView.load(
            url,
            fallbackDrawable,
            errorDrawable ?: fallbackDrawable
        )
    }

}