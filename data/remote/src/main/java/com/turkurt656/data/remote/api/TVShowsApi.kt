package com.turkurt656.data.remote.api

import com.turkurt656.data.remote.dto.tvshow.GetPopularShowsResponseRemote
import com.turkurt656.data.remote.dto.tvshow.TVShowDetailRemote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsApi {

    @GET("tv/popular")
    suspend fun getPopularShows(@Query("page") page: Int): GetPopularShowsResponseRemote

    @GET("tv/{id}")
    suspend fun getTVShowDetail(@Path("id")id: Long): TVShowDetailRemote

}