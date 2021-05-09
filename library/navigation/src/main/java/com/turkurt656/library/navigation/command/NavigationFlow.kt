package com.turkurt656.library.navigation.command

import androidx.navigation.NavDirections
import com.turkurt656.feature.splash.ui.SplashFragmentDirections
import com.turkurt656.feature.tvshow.ui.popular.PopularTVShowFragmentDirections
import com.turkurt656.library.navigation.command.NavigationFlow.*

sealed class NavigationFlow {
    object SplashToTvShows : NavigationFlow()
    data class PopularShowsToDetail(val showId: Long) : NavigationFlow()
}


fun NavigationFlow.toNavDirections(): NavDirections =
    when (this) {
        is SplashToTvShows -> SplashFragmentDirections.toTvShow()
        is PopularShowsToDetail -> PopularTVShowFragmentDirections.toDetail(showId)
    }