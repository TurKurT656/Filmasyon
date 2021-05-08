package com.turkurt656.data.domainimpl.mapping.tvshow

import com.turkurt656.data.domain.dto.tvshow.TVShow
import com.turkurt656.data.remote.dto.tvshow.TVShowRemote

fun TVShowRemote.toDomain() =
    TVShow(id, posterPath, voteAverage, name)

fun List<TVShowRemote>.toDomain() =
    map { it.toDomain() }