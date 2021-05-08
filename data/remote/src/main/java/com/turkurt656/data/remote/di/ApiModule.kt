package com.turkurt656.data.remote.di

import com.turkurt656.data.remote.api.TVShowsApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val apiModule = module {

    factory<TVShowsApi> { get<Retrofit>().create() }

}