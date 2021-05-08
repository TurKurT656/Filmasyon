package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.repository.TVShowRepository
import com.turkurt656.data.domainimpl.repository.TVShowRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<TVShowRepository> { TVShowRepositoryImpl(get()) }

}