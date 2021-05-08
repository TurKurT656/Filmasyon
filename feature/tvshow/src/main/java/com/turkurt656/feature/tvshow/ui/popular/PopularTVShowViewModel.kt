package com.turkurt656.feature.tvshow.ui.popular

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.*
import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.domain.usecase.tvshow.GetPopularShowsUseCase

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

}