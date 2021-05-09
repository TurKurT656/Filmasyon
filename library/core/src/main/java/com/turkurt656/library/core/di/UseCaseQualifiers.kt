package com.turkurt656.library.core.di

import org.koin.core.qualifier.named

object UseCaseQualifiers {

    val GET_POPULAR_SHOWS_USE_CASE = named("GET_POPULAR_SHOWS_USE_CASE")
    val GET_TV_SHOW_DETAIL_USE_CASE = named("GET_TV_SHOW_DETAIL_USE_CASE")

}