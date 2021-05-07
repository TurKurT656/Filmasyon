package com.turkurt656.library.navigation.command

import androidx.navigation.NavDirections
import com.turkurt656.feature.splash.ui.SplashFragmentDirections

sealed class NavigationFlow {
    object SplashToTvShows : NavigationFlow()
}


fun NavigationFlow.toNavDirections(): NavDirections =
    when (this) {
        is NavigationFlow.SplashToTvShows -> SplashFragmentDirections.toTvShow()
    }