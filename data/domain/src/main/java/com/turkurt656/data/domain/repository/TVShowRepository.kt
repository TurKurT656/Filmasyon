package com.turkurt656.data.domain.repository

import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.domain.result.FlowResult

interface TVShowRepository {

    fun getPopularShows(page: Int): FlowResult<List<TVShow>>

}