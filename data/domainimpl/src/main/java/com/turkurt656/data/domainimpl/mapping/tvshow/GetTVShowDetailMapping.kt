package com.turkurt656.data.domainimpl.mapping.tvshow

import com.turkurt656.data.domain.dto.tvshow.Genre
import com.turkurt656.data.domain.dto.tvshow.TVShowDetail
import com.turkurt656.data.remote.dto.tvshow.GenreRemote
import com.turkurt656.data.remote.dto.tvshow.TVShowDetailRemote

fun TVShowDetailRemote.toDomain() =
    TVShowDetail(
        id,
        posterPath,
        backdropPath,
        voteAverage,
        name,
        genres.toDomain(),
        homepage,
        numberOfEpisodes,
        numberOfSeasons,
        overview,
    )

fun GenreRemote.toDomain() = Genre(id, name)

fun List<GenreRemote>.toDomain() = map { it.toDomain() }