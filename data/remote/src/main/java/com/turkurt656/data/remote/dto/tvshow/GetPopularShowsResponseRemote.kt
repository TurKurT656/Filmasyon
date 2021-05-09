package com.turkurt656.data.remote.dto.tvshow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetPopularShowsResponseRemote(
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "results")
    val results: List<TVShowRemote>

)

@JsonClass(generateAdapter = true)
data class TVShowRemote(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "vote_average")
    val voteAverage: Float,
    @field:Json(name = "name")
    val name: String,
)

/*

Example success response:

{
  "page": 1,
  "results": [
    {
      "poster_path": "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
      "popularity": 47.432451,
      "id": 31917,
      "backdrop_path": "/rQGBjWNveVeF8f2PGRtS85w9o9r.jpg",
      "vote_average": 5.04,
      "overview": "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name \"A\" who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
      "first_air_date": "2010-06-08",
      "origin_country": [
        "US"
      ],
      "genre_ids": [
        18,
        9648
      ],
      "original_language": "en",
      "vote_count": 133,
      "name": "Pretty Little Liars",
      "original_name": "Pretty Little Liars"
    }
  ]
}

 */