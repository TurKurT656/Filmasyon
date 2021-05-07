package com.turkurt656.feature.splash.ui

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.launch
import com.turkurt656.library.navigation.command.NavigationFlow.SplashToTvShows
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel() {

    init {
        navigateToTVShows()
    }

    private fun navigateToTVShows() = launch {
        delay(1_000)
        navigateTo(SplashToTvShows)
    }

}