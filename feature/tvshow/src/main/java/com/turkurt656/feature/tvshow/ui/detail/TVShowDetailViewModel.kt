package com.turkurt656.feature.tvshow.ui.detail

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.*
import com.turkurt656.data.domain.dto.tvshow.TVShowDetail
import com.turkurt656.data.domain.usecase.tvshow.GetTVShowDetailUseCase

class TVShowDetailViewModel(
    private val showId: Long,
    private val getTVShowDetailUseCase: GetTVShowDetailUseCase,
) : BaseViewModel() {

    private val _tvShowDetail = MutableLiveResult<TVShowDetail>()
    val tvShowDetail = _tvShowDetail.mapData()

    init {
        getDetail()
    }

    private fun getDetail() = launch {
        getTVShowDetailUseCase(showId)
            .collectOnLiveData(
                _tvShowDetail,
                this@TVShowDetailViewModel
            )
    }


}