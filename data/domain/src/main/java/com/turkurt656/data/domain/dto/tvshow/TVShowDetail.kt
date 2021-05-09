package com.turkurt656.data.domain.dto.tvshow

data class TVShowDetail(
    val id: Long,
    val posterPath: String,
    val backdropPath: String?,
    val voteAverage: Float,
    val name: String,
    val genres: List<Genre>,
    val homepage: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val overview: String,
)

data class Genre(
    val id: Long,
    val name: String,
)