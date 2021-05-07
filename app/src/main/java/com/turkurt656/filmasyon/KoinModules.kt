package com.turkurt656.filmasyon

import com.turkurt656.data.domainimpl.di.repositoryModule
import com.turkurt656.data.domainimpl.di.useCaseModule
import com.turkurt656.data.local.di.dataStoreModule
import com.turkurt656.data.remote.di.apiModule
import com.turkurt656.data.remote.di.networkModule
import com.turkurt656.feature.splash.di.splashFeatureModule
import com.turkurt656.feature.tvshow.di.tVShowFeatureModule
import com.turkurt656.library.core.di.GlobalQualifiers.IS_DEBUG
import com.turkurt656.library.imageloader.di.imageLoaderModule
import org.koin.dsl.module

val appModule = module {

    factory(IS_DEBUG) { BuildConfig.DEBUG }

}

val koinModules = listOf(
    appModule,
    imageLoaderModule,
    dataStoreModule,
    apiModule,
    networkModule,
    repositoryModule,
    useCaseModule,
    splashFeatureModule,
    tVShowFeatureModule,
)