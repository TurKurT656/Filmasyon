package com.turkurt656.library.imageloader.di

import coil.ImageLoader
import coil.util.Logger
import com.turkurt656.library.imageloader.logger.CoilLogger
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val imageLoaderModule = module {

    single {
        ImageLoader.Builder(androidContext())
            .logger(get())
            .crossfade(true)
            .build()
    }

    factory<Logger> { CoilLogger() }

}