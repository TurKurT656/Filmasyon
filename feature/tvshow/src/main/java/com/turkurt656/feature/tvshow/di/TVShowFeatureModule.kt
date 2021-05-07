package com.turkurt656.feature.tvshow.di

import com.turkurt656.feature.tvshow.ui.popular.PopularTVShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tVShowFeatureModule  = module {

    viewModel { PopularTVShowViewModel() }

}
