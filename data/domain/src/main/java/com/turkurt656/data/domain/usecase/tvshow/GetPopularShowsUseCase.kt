package com.turkurt656.data.domain.usecase.tvshow

import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.domain.result.FlowResult

typealias GetPopularShowsUseCase = (page: Int) -> FlowResult<List<TVShow>>