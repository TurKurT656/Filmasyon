package com.turkurt656.data.domain.usecase.tvshow

import com.turkurt656.data.domain.dto.tvshow.TVShowDetail
import com.turkurt656.data.domain.result.FlowResult

typealias GetTVShowDetailUseCase = (id: Long) -> FlowResult<TVShowDetail>