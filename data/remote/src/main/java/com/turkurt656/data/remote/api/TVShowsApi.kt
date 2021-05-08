package com.turkurt656.data.remote.api

import com.turkurt656.data.remote.dto.tvshow.GetPopularShowsResponseRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface TVShowsApi {

    @GET("tv/popular")
    suspend fun getPopularShows(@Query("page") page: Int): GetPopularShowsResponseRemote

}