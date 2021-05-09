package com.turkurt656.feature.tvshow.ui.popular

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.*
import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.domain.usecase.tvshow.GetPopularShowsUseCase
import com.turkurt656.library.navigation.command.NavigationFlow
import com.turkurt656.library.navigation.command.NavigationFlow.*

class PopularTVShowViewModel(
    private val getPopularShowsUseCase: GetPopularShowsUseCase,
): BaseViewModel() {

    private val _popularShows = MutableLiveResult<List<TVShow>>()
    val popularShows: LiveResult<List<TVShow>> = _popularShows

    fun fetchPopularShows(page: Int) = launch {
        getPopularShowsUseCase(page)
            .collectOnLiveData(
                _popularShows,
                this@PopularTVShowViewModel,
            )
    }

    fun onFilterListClicked() {
        showSnackBar("Coming soon...")
    }

    fun navigateToDetail(tvShow: TVShow) {
        navigateTo(PopularShowsToDetail(tvShow.id))
    }

}