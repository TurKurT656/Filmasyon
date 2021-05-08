package com.turkurt656.data.domainimpl.repository

import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.domain.repository.TVShowRepository
import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domainimpl.mapping.tvshow.toDomain
import com.turkurt656.data.domainimpl.result.flowResult
import com.turkurt656.data.remote.api.TVShowsApi

class TVShowRepositoryImpl(
    private val tvShowsApi: TVShowsApi
) : TVShowRepository {

    private val _popularShows = mutableListOf<TVShow>()

    override fun getPopularShows(page: Int): FlowResult<List<TVShow>> =
        flowResult(_popularShows) {
            val shows = tvShowsApi.getPopularShows(page).results.toDomain()
            if (page == 1) _popularShows.clear()
            _popularShows.addAll(shows)
            return@flowResult _popularShows
        }


}