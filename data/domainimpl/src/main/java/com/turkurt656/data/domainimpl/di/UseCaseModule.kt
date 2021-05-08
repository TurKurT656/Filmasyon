package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.repository.TVShowRepository
import com.turkurt656.data.domain.usecase.tvshow.GetPopularShowsUseCase
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_POPULAR_SHOWS_USE_CASE
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetPopularShowsUseCase>(GET_POPULAR_SHOWS_USE_CASE) {
        get<TVShowRepository>()::getPopularShows
    }

}