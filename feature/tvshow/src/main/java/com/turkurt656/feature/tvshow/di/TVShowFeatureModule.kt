package com.turkurt656.feature.tvshow.di

import com.turkurt656.feature.tvshow.ui.popular.PopularTVShowViewModel
import com.turkurt656.feature.tvshow.ui.popular.TVShowAdapter
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_POPULAR_SHOWS_USE_CASE
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tVShowFeatureModule  = module {

    viewModel { PopularTVShowViewModel(get(GET_POPULAR_SHOWS_USE_CASE)) }

    factory { TVShowAdapter() }

}
