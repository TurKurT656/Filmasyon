package com.turkurt656.library.imageloader

import coil.Coil
import coil.ImageLoader
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
object ImageLoader : KoinComponent {

    private val imageLoader: ImageLoader by inject()

    fun init() =
        Coil.setImageLoader(imageLoader)

}